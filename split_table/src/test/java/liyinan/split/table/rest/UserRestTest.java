package liyinan.split.table.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRestTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestTest.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    UserRest userRest;

    @ParameterizedTest
    @CsvSource({
            "李靠谱, 26",
            "邢邢好棒, 3"
    })
    public void save(String name, Integer age) {
        userRest.save(name, age);
    }

    @Test
    public void list() throws JsonProcessingException {
        LOGGER.info(OBJECT_MAPPER.writeValueAsString(userRest.list()));
    }
}