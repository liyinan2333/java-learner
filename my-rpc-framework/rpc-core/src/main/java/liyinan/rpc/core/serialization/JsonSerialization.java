package liyinan.rpc.core.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * 为消息传输提供序列化和反序列化服务
 *
 * @author liyinan2333
 * @date 2022/2/10
 */
public class JsonSerialization {

    private static ObjectMapper objectMapper = new ObjectMapper();

    static {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static byte[] serialize(Object output) throws JsonProcessingException {
        byte[] bytes = objectMapper.writeValueAsBytes(output);
        return bytes;
    }

    public static Object deserialize(byte[] input,Class clazz) throws IOException {
        Object parse = objectMapper.readValue(input,clazz);
        return parse;
    }
}