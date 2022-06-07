package liyinan.proxy.jdk;

import liyinan.proxy.jdk.service.IUserService;

public class UserService implements IUserService {
    @Override
    public void insert(String name) {
        System.out.println(String.format("用户[name:%s]插入成功!", name));
    }
}
