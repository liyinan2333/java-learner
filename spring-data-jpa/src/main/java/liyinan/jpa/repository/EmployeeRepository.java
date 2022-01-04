package liyinan.jpa.repository;


import liyinan.jpa.bean.Employee;
import org.springframework.data.repository.Repository;

import java.time.Instant;

public interface EmployeeRepository extends Repository<Employee, Integer> {

    Employee findByNameAndAge(String name, Integer age);

    Employee findByNameOrAge(String name, Integer age);

    Employee findByAgeBetween(Integer start, Integer end);

    Employee findByAgeLessThan(Integer age);

    Employee findByAgeGreaterThan(Integer age);

    Employee findByBirthdayAfter(Instant birthday);
}
