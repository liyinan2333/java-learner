package liyinan.jpa.repository;

import liyinan.jpa.bean.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Instant;
import java.util.*;
import java.util.stream.Stream;

@SpringBootTest
@DisplayName("JPA接口名称规则测试")
class EmployeeMethodNameRepositoryTest {

    @Autowired
    EmployeeMethodNameRepository repository;

    @ParameterizedTest
    @CsvSource({"test1, 22"})
    void findByNameAndAge(String name, Integer age) {
//        Optional<Employee> optional = repository.findByNameAndAge(name, age);
//        optional.ifPresent(System.out::println);
        Collection<Employee> employees = repository.findByNameAndAge(name, age);
        employees.stream().forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"test1, 22"})
    void findByNameOrAge(String name, Integer age) {
        Collection<Employee> employees = repository.findByNameOrAge(name, age);
        employees.stream().forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({"21, 22"})
    void findByAgeBetween(Integer start, Integer end) {
        Collection<Employee> employees = repository.findByAgeBetween(start, end);
        employees.stream().forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints = {21, 20, 18})
    void findByAgeLessThan(Integer age) {
        Collection<Employee> employees = repository.findByAgeLessThan(age);
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints = {21, 20, 18})
    void findByAgeGreaterThan(Integer age) {
        Collection<Employee> employees = repository.findByAgeGreaterThan(age);
        employees.forEach(System.out::println);
    }

    @Test
    void findByBirthdayAfter() {
        Collection<Employee> employees = repository.findByBirthdayAfter(Instant.parse("2003-01-01T00:00:00Z"));
        employees.forEach(System.out::println);
//        System.out.println(Instant.now().plus(Duration.ofHours(8)));
    }

    @Test
    void findByBirthdayBefore() {
        Collection<Employee> employees = repository.findByBirthdayBefore(Instant.parse("2003-01-01T00:00:00Z"));
        employees.forEach(System.out::println);
    }

    @Test
    void findByAgeIsNull() {
        Collection<Employee> employees = repository.findByAgeIsNull();
        employees.forEach(System.out::println);
    }

    @Test
    void findByAgeNotNull() {
        Collection<Employee> employees = repository.findByAgeNotNull();
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1%", "test2%"})
    void findByNameLike(String pattern) {
        Collection<Employee> employees = repository.findByNameLike(pattern);
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1%", "test2%"})
    void findByNameNotLike(String pattern) {
        Collection<Employee> employees = repository.findByNameNotLike(pattern);
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1", "test2"})
    void findByNameStartingWith(String starting) {
        Collection<Employee> employees = repository.findByNameStartingWith(starting);
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1", "test2"})
    void findByNameEndingWith(String ending) {
        Collection<Employee> employees = repository.findByNameEndingWith(ending);
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"test1", "test2"})
    void findByNameContaining(String contains) {
        Collection<Employee> employees = repository.findByNameContaining(contains);
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints = {20})
    void findByAgeOrderByBirthday(Integer age) {
        Collection<Employee> employees = repository.findByAgeOrderByBirthday(age);
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints = {20, 22})
    void findByAgeNot(Integer age) {
        Collection<Employee> employees = repository.findByAgeNot(age);
        employees.forEach(System.out::println);
    }

    @ParameterizedTest
    @MethodSource("findByAgeNotInParam")
    void findByAgeNotIn(Collection ages) {
        Collection<Employee> employees = repository.findByAgeNotIn(ages);
        employees.forEach(System.out::println);
    }

    public static Stream<Arguments> findByAgeNotInParam() {
        List<Integer> param1 = new ArrayList<>();
        param1.add(20);
        param1.add(22);
        List<Integer> param2 = new ArrayList<>();
        param2.add(19);
        return Stream.of(Arguments.arguments(param1), Arguments.arguments(param2));
    }

    @Test
    void findByDelTagTrue() {
        Collection<Employee> employees = repository.findByDelTagTrue();
        employees.forEach(System.out::println);
    }

    @Test
    void findByDelTagFalse() {
        Collection<Employee> employees = repository.findByDelTagFalse();
        employees.forEach(System.out::println);
    }
}