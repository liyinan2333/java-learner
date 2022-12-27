package liyinan.split.table.service;

import liyinan.split.table.mapper.User1Mapper;
import liyinan.split.table.mapper.User2Mapper;
import liyinan.split.table.mapper.UserAllMapper;
import liyinan.split.table.pojo.User;
import liyinan.split.table.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    User1Mapper user1Mapper;
    @Autowired
    User2Mapper user2Mapper;
    @Autowired
    UserAllMapper userAllMapper;

    public int save(String name, Integer age) {
        Long id = IdUtil.getId();
        if (id % 2 == 1L) {
            return user1Mapper.insert(id, name, age);
        } else {
            return user2Mapper.insert(id, name, age);
        }
    }

    public List<Map<String, User>> list() {
        return userAllMapper.queryAll();
    }

}
