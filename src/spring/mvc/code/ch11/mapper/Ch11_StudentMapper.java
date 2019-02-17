package spring.mvc.code.ch11.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import spring.mvc.code.ch11.domain.Ch11_Student;

import java.util.List;

public interface Ch11_StudentMapper {

    // 根據班級id查詢班級所有學生
    @Select("SELECT * FROM TB_CH11_STUDENT WHERE CLAZZ_ID = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="age",property="age")
    })
    List<Ch11_Student> selectByClazzId(Integer clazz_id);
}
