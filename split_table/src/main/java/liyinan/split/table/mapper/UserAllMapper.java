package liyinan.split.table.mapper;

import liyinan.split.table.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserAllMapper {

    @Select("select * from user_all;")
    List<Map<String, User>> queryAll();

}
