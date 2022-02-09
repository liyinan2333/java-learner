package liyinan.jpa.repository;


import liyinan.jpa.bean.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.Collection;

/**
 * 注解或继承二选一
 *
 * @author LiYinan
 * @date 2022/02/06
 */
//@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeQueryAnnotationRepository extends Repository<Employee, Integer> {

    @Query("select o from Employee o where id=(select max(id) from Employee t1)")
    Employee findEmployeeByMaxId();

}
