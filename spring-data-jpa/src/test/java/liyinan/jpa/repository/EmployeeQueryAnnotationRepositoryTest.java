package liyinan.jpa.repository;

import liyinan.jpa.bean.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JPA接口Query注解测试")
class EmployeeQueryAnnotationRepositoryTest {

    @Autowired
    EmployeeQueryAnnotationRepository repository;

    @Test
    void findEmployeeByMaxId() {
        Employee employee = repository.findEmployeeByMaxId();
        System.out.println(employee);
    }

}