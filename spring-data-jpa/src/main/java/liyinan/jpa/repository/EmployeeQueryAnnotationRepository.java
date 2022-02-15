package liyinan.jpa.repository;


import liyinan.jpa.bean.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 注解或继承二选一
 *
 * @author LiYinan
 * @date 2022/02/06
 */
//@RepositoryDefinition(domainClass = Employee.class, idClass = Integer.class)
public interface EmployeeQueryAnnotationRepository extends Repository<Employee, Integer> {

    @Query("select o from Employee o where o.id=(select max(t1.id) from Employee t1)")
    Employee findEmployeeByMaxId();

    @Query("select o from Employee o where o.name=?1 and o.age=?2")
    List<Employee> findParams1(String name, Integer age);

    @Query("select o from Employee o where o.name=:name and o.age=:age")
    List<Employee> findParams2(@Param("name") String name, @Param("age") Integer age);

    @Query("select o from Employee o where o.name like %?1%")
    List<Employee> findLike1(String name);

    @Query("select o from Employee o where o.name like %:name%")
    List<Employee> findLike2(@Param("name") String name);

    // nativeQuery=true 启用原生sql支持
    @Query(nativeQuery = true, value = "select count(1) from employee")
    Integer getCount();
}
