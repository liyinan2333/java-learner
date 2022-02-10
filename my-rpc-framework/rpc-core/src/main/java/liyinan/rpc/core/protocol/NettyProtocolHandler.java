package liyinan.rpc.core.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import liyinan.rpc.core.serialization.JsonSerialization;
import liyinan.rpc.core.util.ByteUtils;

/**
 * 网络传输的自定义TCP协议 [0x15 0x66 LENGTH(4Bytes) DATA]
 * 发送时：为传输的字节流添加两个魔数作为头部，再计算数据的长度，将数据长度也添加到头部，最后才是数据
 * 接收时：识别出两个魔数后，下一个就是首部，最后使用长度对应的字节数组接收数据
 *
 * @author liyinan2333
 * @date 2022/2/10
 */
public class NettyProtocolHandler extends ChannelDuplexHandler {

    private static final byte[] MAGIC = new byte[]{0x15, 0x66};

    private Class decodeType;

    public NettyProtocolHandler() {
    }

    public NettyProtocolHandler(Class decodeType) {
        this.decodeType = decodeType;
    }

    @Override
    public void channelRead(ChannelHandlerContext context, Object message) throws Exception {

        ByteBuf in = (ByteBuf) message;

        byte[] header = new byte[2];
        // 读取魔数
        in.readBytes(header);
        // 读取长度
        byte[] lenByte = new byte[4];
        in.readBytes(lenByte);
        int len = ByteUtils.Bytes2Int_BE(lenByte);
        // 根据长度读取数据
        byte[] object = new byte[len];
        in.readBytes(object);

        // 反序列化
        Object deserializeObject = JsonSerialization.deserialize(object, decodeType);
        //交给下一个数据处理器
        context.fireChannelRead(deserializeObject);
    }

    @Override
    public void write(ChannelHandlerContext context, Object message, ChannelPromise promise) throws Exception {

        ByteBuf byteBuf = Unpooled.buffer();
        // 序列化
        byte[] object = JsonSerialization.serialize(message);
        //计算长度
        byte[] bodyLen = ByteUtils.int2bytes(object.length);

        //写入魔数
        byteBuf.writeBytes(MAGIC);
        // 写入长度
        byteBuf.writeBytes(bodyLen);
        //写入对象
        byteBuf.writeBytes(object);

        context.writeAndFlush(byteBuf);
    }
}