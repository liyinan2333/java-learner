package liyinan.jpa.service.impl;

import liyinan.jpa.bean.Employee;
import liyinan.jpa.repository.EmployeeCrudRepository;
import liyinan.jpa.service.EmployeeCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.Instant;

/**
 * 更新数据操作需要将Repository封装为事务才能调用
 *
 * @author LiYinan
 * @date 2022/02/12
 */
@Service
public class EmployeeCrudServiceImpl implements EmployeeCrudService {

    @Autowired
    EmployeeCrudRepository repository;


    @Override
    @Transactional
    public void saveAndDelete() {
        Employee employee = new Employee();
        employee.setName("testCrudSave");
        employee.setAge(999);
        employee.setBirthday(Instant.now().plus(Duration.ofHours(8)));

        repository.save(employee);
        repository.delete(employee);
    }
}
