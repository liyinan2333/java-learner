package liyinan.jpa.repository;

import liyinan.jpa.bean.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("JPA接口名称规则测试")
class EmployeeMethodNameRepositoryTest {

    @Autowired
    EmployeeMethodNameRepository repository;

    @ParameterizedTest
    @ValueSource()
    @CsvSource({
            "test1", "22",
            "test2", "30"
    })
    void findByNameAndAge(String name, Integer age) {
        Optional<Employee> optional = repository.findByNameAndAge(name, age);
        optional.ifPresent(System.out::println);
    }

    //
//    @Test
//    void findByNameOrAge(String name, Integer age) {
//    }
//
//    @Test
//    void findByAgeBetween(Integer start, Integer end) {
//    }
//
    @ParameterizedTest
    @ValueSource(ints = {21, 20, 18})
    void findByAgeLessThan(Integer age) {
        Collection<Employee> employees = repository.findByAgeLessThan(age);
        employees.forEach(System.out::println);
    }
//
//    @Test
//    void findByAgeGreaterThan(Integer age) {
//    }
//
//    @Test
//    void findByBirthdayAfter(Instant birthday) {
//    }
//
//    @Test
//    void findByBirthdayBefore(Instant birthday) {
//    }
//
//    @Test
//    void findByAgeIsNull() {
//    }
//
//    @Test
//    void findByAgeNotNull() {
//    }
//
//    @Test
//    void findByNameLike(String pattern) {
//    }
//
//    @Test
//    void findByNameNotLike(String pattern) {
//    }
//
//    @Test
//    void findByNameStartingWith(String starting) {
//    }
//
//    @Test
//    void findByNameEndingWith(String ending) {
//    }
//
//    @Test
//    void findByNameContaining(String contains) {
//    }
//
//    @Test
//    void findByAgeOrderByBirthday(Integer age) {
//    }
//
//    @Test
//    void findByAgeNot(Integer age) {
//    }
//
//    @Test
//    void findByAgeNotIn(Collection ages) {
//    }
//
//    @Test
//    void findByDelTagTrue() {
//    }
//
//    @Test
//    void findByDelTagFalse() {
//    }
}