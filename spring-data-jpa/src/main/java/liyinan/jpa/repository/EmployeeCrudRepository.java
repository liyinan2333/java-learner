package liyinan.jpa.repository;

import liyinan.jpa.bean.Employee;
import org.springframework.data.repository.CrudRepository;

/**
 * CRUD的api
 *
 * @author LiYinan
 * @date 2022/02/12
 */
//@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

}
