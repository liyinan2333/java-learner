package liyinan.jpa.repository;

import liyinan.jpa.bean.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @ParameterizedTest
    @CsvSource({"test1, 22"})
    void queyParams1(String name, Integer age) {
        List<Employee> employees = repository.findParams1(name, age);
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"test1, 22"})
    void queyParams2(String name, Integer age) {
        List<Employee> employees = repository.findParams2(name, age);
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1"})
    void findLike1(String name) {
        List<Employee> employees = repository.findLike1(name);
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1"})
    void findLike2(String name) {
        List<Employee> employees = repository.findLike2(name);
        employees.forEach(System.out::println);
    }

    @Test
    void getCount() {
        Integer count = repository.getCount();
        System.out.println(count);
    }

}