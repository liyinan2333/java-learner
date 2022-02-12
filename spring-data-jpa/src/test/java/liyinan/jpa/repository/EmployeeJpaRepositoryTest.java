package liyinan.jpa.repository;

import liyinan.jpa.bean.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;

import java.util.Optional;

@SpringBootTest
@DisplayName("JPA Jpa父接口测试")
class EmployeeJpaRepositoryTest {

    @Autowired
    EmployeeJpaRepository repository;

    @Test
    void find() {
        Employee employee = new Employee();
        employee.setId(1);
        Optional<Employee> find = repository.findOne(Example.of(employee));
        System.out.println(find.get());
    }

    @Test
    void exists() {
        Employee employee = new Employee();
        employee.setAge(20);
        System.out.println(repository.existsById(999));
        System.out.println(repository.exists(Example.of(employee)));
    }

}