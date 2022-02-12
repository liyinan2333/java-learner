package liyinan.jpa.service.impl;

import liyinan.jpa.repository.EmployeeTransactionRepository;
import liyinan.jpa.service.EmployeeTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 更新数据操作需要将Repository封装为事务才能调用
 *
 * @author LiYinan
 * @date 2022/02/12
 */
@Service
public class EmployeeTransactionServiceImpl implements EmployeeTransactionService {

    @Autowired
    EmployeeTransactionRepository repository;


    @Override
    @Transactional
    public void update(Integer id, Integer age) {
        repository.update(id, age);
    }
}
