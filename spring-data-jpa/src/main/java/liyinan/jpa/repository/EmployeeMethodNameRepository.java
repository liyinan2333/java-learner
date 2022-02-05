package liyinan.jpa.repository;


import liyinan.jpa.bean.Employee;
import org.springframework.data.repository.Repository;

import java.time.Instant;
import java.util.Collection;

/**
 * 注解或继承二选一
 *
 * @author LiYinan
 * @date 2022/01/05
 */
//@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeMethodNameRepository extends Repository<Employee, Integer> {

//    Optional<Employee> findByNameAndAge(String name, Integer age);
Collection<Employee> findByNameAndAge(String name, Integer age);

    Collection<Employee> findByNameOrAge(String name, Integer age);

    Collection<Employee> findByAgeBetween(Integer start, Integer end);

    Collection<Employee> findByAgeLessThan(Integer age);

    Collection<Employee> findByAgeGreaterThan(Integer age);

    Collection<Employee> findByBirthdayAfter(Instant birthday);

    Collection<Employee> findByBirthdayBefore(Instant birthday);

    Collection<Employee> findByAgeIsNull();

    Collection<Employee> findByAgeNotNull();
//    Employee findByAgeIsNotNull();

    Collection<Employee> findByNameLike(String pattern);

    Collection<Employee> findByNameNotLike(String pattern);

    Collection<Employee> findByNameStartingWith(String starting);

    Collection<Employee> findByNameEndingWith(String ending);

    Collection<Employee> findByNameContaining(String contains);

    Collection<Employee> findByAgeOrderByBirthday(Integer age);

    Collection<Employee> findByAgeNot(Integer age);

    Collection<Employee> findByAgeNotIn(Collection ages);

    Collection<Employee> findByDelTagTrue();

    Collection<Employee> findByDelTagFalse();

}
