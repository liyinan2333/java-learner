package liyinan.rpc.core.util;

import java.nio.ByteBuffer;

/**
 * @author liyinan2333
 * @date 2022/2/10
 */
public class ByteUtils {

    /** short2\u5B57\u8282\u6570\u7EC4 */
    public static byte[] short2bytes(short v) {
        byte[] b = new byte[4];
        b[1] = (byte) v;
        b[0] = (byte) (v >>> 8);
        return b;
    }

    /** int4\u5B57\u8282\u6570\u7EC4 */
    public static byte[] int2bytes(int v) {
        byte[] b = new byte[4];
        b[3] = (byte) v;
        b[2] = (byte) (v >>> 8);
        b[1] = (byte) (v >>> 16);
        b[0] = (byte) (v >>> 24);
        return b;
    }

    /** long8\u5B57\u8282\u6570\u7EC4 */
    public static byte[] long2bytes(long v) {
        byte[] b = new byte[8];
        b[7] = (byte) v;
        b[6] = (byte) (v >>> 8);
        b[5] = (byte) (v >>> 16);
        b[4] = (byte) (v >>> 24);
        b[3] = (byte) (v >>> 32);
        b[2] = (byte) (v >>> 40);
        b[1] = (byte) (v >>> 48);
        b[0] = (byte) (v >>> 56);
        return b;
    }

    /** \u5B57\u8282\u6570\u7EC4\u8F6C\u5B57\u7B26\u4E32 */
    public static String bytesToHexString(byte[] bs) {
        if (bs == null || bs.length == 0) {
            return null;
        }

        StringBuffer sb = new StringBuffer();
        String tmp = null;
        for (byte b : bs) {
            tmp = Integer.toHexString(Byte.toUnsignedInt(b));
            if (tmp.length() < 2) {
                sb.append(0);
            }
            sb.append(tmp);
        }
        return sb.toString();
    }

    /**
     * @return
     */
    public static int Bytes2Int_BE(byte[] bytes) {
        if(bytes.length < 4){
            return -1;
        }
        int iRst = (bytes[0] << 24) & 0xFF;
        iRst |= (bytes[1] << 16) & 0xFF;
        iRst |= (bytes[2] << 8) & 0xFF;
        iRst |= bytes[3] & 0xFF;
        return iRst;
    }

    /**
     * long\u8F6C8\u5B57\u8282\u6570\u7EC4
     */
    public static long bytes2long(byte[] b) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.put(b, 0, b.length);
        buffer.flip();// need flip
        return buffer.getLong();
    }
}