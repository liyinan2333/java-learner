package liyinan.jpa.repository;

import liyinan.jpa.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * 自定义查询过滤规则
 *
 * @author LiYinan
 * @date 2022/02/12
 */
//@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeJpaSpecificationExecutorRepository extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor {

}
