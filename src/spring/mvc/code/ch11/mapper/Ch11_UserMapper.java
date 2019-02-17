package spring.mvc.code.ch11.mapper;

import org.apache.ibatis.annotations.*;
import spring.mvc.code.ch11.domain.Ch11_User;

import java.util.List;

public interface Ch11_UserMapper {

    @Insert("INSERT INTO TB_CH11_USER(name,sex,age) VALUES(#{name},#{sex},#{age})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int saveUser(Ch11_User user);

    @Delete("DELETE FROM TB_CH11_USER WHERE id = #{id}")
    int removeUser(@Param("id") Integer id);

    @Update("UPDATE TB_CH11_USER SET name = #{name},sex = #{sex},age = #{age} WHERE id = #{id}")
    void modifyUser(Ch11_User user);

    @Select("SELECT * FROM TB_CH11_USER WHERE id = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="age",property="age")
    })
    Ch11_User selectUserById(@Param("id") Integer id);

    @Select("SELECT * FROM TB_CH11_USER ")
    List<Ch11_User> selectAllUser();
}
