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

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@DisplayName("JPA 分页和排序父接口测试")
class EmployeePagingAndSortingRepositoryTest {

    @Autowired
    EmployeePagingAndSortingRepository repository;

    @Test
    void paging() {
        // 这里注意，页码是从0开始的
        Pageable pageable = PageRequest.of(0, 5);
        Page<Employee> page = repository.findAll(pageable);

        System.out.println("查询的总页数 ->" + page.getTotalPages());
        System.out.println("查询的总记录数 ->" + page.getTotalElements());
        // 页码默认从0开始，这里+1处理
        System.out.println("查询的当前页码 ->" + page.getNumber() + 1);
        System.out.println("查询的当前页面的集合 ->" + page.getContent());
        System.out.println("查询的当前页面的记录数 ->" + page.getNumberOfElements());
    }

    @Test
    void sorting() {
        // 排序规则
        List<Sort.Order> orders = new ArrayList<>();
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        orders.add(order);
        Sort sort = Sort.by(orders);
        // 分页 这里注意，页码是从0开始的
        Pageable pageable = PageRequest.of(0, 5, sort);

        Page<Employee> page = repository.findAll(pageable);

        System.out.println("查询的总页数 ->" + page.getTotalPages());
        System.out.println("查询的总记录数 ->" + page.getTotalElements());
        // 页码默认从0开始，这里+1处理
        System.out.println("查询的当前页码 ->" + page.getNumber() + 1);
        System.out.println("查询的当前页面的集合 ->" + page.getContent());
        System.out.println("查询的当前页面的记录数 ->" + page.getNumberOfElements());
    }

}