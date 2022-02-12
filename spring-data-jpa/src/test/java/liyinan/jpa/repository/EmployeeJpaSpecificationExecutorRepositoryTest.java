package liyinan.jpa.repository;

import liyinan.jpa.bean.Employee;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DisplayName("JPA 自定义查询过滤条件测试")
class EmployeeJpaSpecificationExecutorRepositoryTest {

    @Autowired
    EmployeeJpaSpecificationExecutorRepository repository;

    /**
     * 分页+排序+查询条件
     */
    @Test
    void specificationExecutor() {
        // 排序规则
        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        orders.add(order);
        Sort sort = Sort.by(orders);
        // 分页 这里注意，页码是从0开始的
        Pageable pageable = PageRequest.of(0, 5, sort);

        /**
         * root: 我们要查询的类型(Employee)
         * query: 添加查询条件
         * builder: 构建Predicate
         */
        Specification<Employee> specification = new Specification<>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
                Path path = root.get("age");
                return builder.greaterThan(path, 20);
            }
        };

        Page<Employee> page = repository.findAll(specification, pageable);

        System.out.println("查询的总页数 ->" + page.getTotalPages());
        System.out.println("查询的总记录数 ->" + page.getTotalElements());
        // 页码默认从0开始，这里+1处理
        System.out.println("查询的当前页码 ->" + (page.getNumber() + 1));
        System.out.println("查询的当前页面的集合 ->" + page.getContent());
        System.out.println("查询的当前页面的记录数 ->" + page.getNumberOfElements());
    }

}