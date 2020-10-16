package leoli.killtrycatch.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 演示
 *
 * @author leoli
 * @date 2020/10/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LicenceServiceTest2 {

    @Autowired
    LicenceService service;

    @Test
    public void assertTest() {
        service.get("12345678");
    }

}