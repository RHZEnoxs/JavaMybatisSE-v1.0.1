package spring.mvc.code.ch11.mapper;

import org.apache.ibatis.annotations.Select;
import spring.mvc.code.ch11.domain.Ch11_ManyToMany_User;

public interface Ch11_ManyToManyUserMapper {

    @Select("SELECT * FROM TB_CH11_MANYTOMANY_USER WHERE ID = #{id} ")
    Ch11_ManyToMany_User selectById(Integer id);
}
