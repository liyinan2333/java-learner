package liyinan.jpa.repository;

import liyinan.jpa.service.EmployeeTransactionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JPA接口事务测试")
class EmployeeTransactionRepositoryTest {

    @Autowired
    EmployeeTransactionService service;

    @ParameterizedTest
    @CsvSource({"1, 22"})
    void update(Integer id, Integer age) {
        service.update(id, age);
    }

}