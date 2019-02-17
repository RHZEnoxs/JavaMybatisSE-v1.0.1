package spring.mvc.code.ch11.mapper;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import spring.mvc.code.ch11.domain.Ch11_Clazz;

public interface Ch11_ClazzMapper {
    // 根據id查詢班級信息
    @Select("SELECT * FROM TB_CH11_CLAZZ  WHERE ID = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="code",property="code"),
            @Result(column="name",property="name"),
            @Result(column="id",property="students",
                    many=@Many(
                            select="spring.mvc.code.ch11.mapper.Ch11_StudentMapper.selectByClazzId",
                            fetchType=FetchType.LAZY))
    })
    Ch11_Clazz selectById(Integer id);
}
