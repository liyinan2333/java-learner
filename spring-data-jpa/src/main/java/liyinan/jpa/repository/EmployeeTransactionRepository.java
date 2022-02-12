package liyinan.jpa.repository;

import liyinan.jpa.bean.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

/**
 * 事务相关
 * 注解或继承二选一
 *
 * @author LiYinan
 * @date 2022/02/12
 */
//@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeTransactionRepository extends Repository<Employee, Integer> {

    @Modifying
    @Query("update Employee o set o.age = :age where o.id = :id")
    void update(@Param("id") Integer id, @Param("age") Integer age);

}
