package liyinan.jpa.repository;

import liyinan.jpa.service.EmployeeCrudService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("JPA CRUD父接口测试")
class EmployeeCrudRepositoryTest {

    @Autowired
    EmployeeCrudService service;

    @Test
    void saveAndDelete() {
        service.saveAndDelete();
    }

}