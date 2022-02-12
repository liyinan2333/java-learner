package liyinan.jpa.repository;

import liyinan.jpa.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 分页和排序的api
 *
 * @author LiYinan
 * @date 2022/02/12
 */
//@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeJpaRepository extends JpaRepository<Employee, Integer> {

}
