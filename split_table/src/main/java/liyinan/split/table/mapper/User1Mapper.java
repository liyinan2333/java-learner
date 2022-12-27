package liyinan.split.table.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface User1Mapper {

    @Insert("insert into user1 values(#{id}, #{name}, #{age});")
    int insert(@Param("id") Long id, @Param("name") String name, @Param("age") Integer age);

}
