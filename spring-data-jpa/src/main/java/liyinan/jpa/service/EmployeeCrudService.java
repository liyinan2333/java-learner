package liyinan.jpa.service;

/**
 * 更新数据操作需要将Repository封装为事务才能调用
 *
 * @author LiYinan
 * @date 2022/02/12
 */
public interface EmployeeCrudService {

    void saveAndDelete();

}
