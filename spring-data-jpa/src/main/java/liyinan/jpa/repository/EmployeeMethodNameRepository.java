package liyinan.jpa.repository;


import liyinan.jpa.bean.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.RepositoryDefinition;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * 注解或继承二选一
 *
 * @author LiYinan
 * @date 2022/01/05
 */
//@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeMethodNameRepository extends Repository<Employee, Integer> {

    Optional<Employee> findByNameAndAge(String name, Integer age);

    Employee findByNameOrAge(String name, Integer age);

    Employee findByAgeBetween(Integer start, Integer end);

    Collection<Employee> findByAgeLessThan(Integer age);

    Employee findByAgeGreaterThan(Integer age);

    Employee findByBirthdayAfter(Instant birthday);

    Employee findByBirthdayBefore(Instant birthday);

    Employee findByAgeIsNull();

    Employee findByAgeNotNull();
//    Employee findByAgeIsNotNull();

    Employee findByNameLike(String pattern);

    Employee findByNameNotLike(String pattern);

    Employee findByNameStartingWith(String starting);

    Employee findByNameEndingWith(String ending);

    Employee findByNameContaining(String contains);

    Employee findByAgeOrderByBirthday(Integer age);

    Employee findByAgeNot(Integer age);

    Employee findByAgeNotIn(Collection ages);

    Employee findByDelTagTrue();

    Employee findByDelTagFalse();

}
