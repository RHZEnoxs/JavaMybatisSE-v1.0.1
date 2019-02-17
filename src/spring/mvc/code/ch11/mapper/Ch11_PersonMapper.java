package spring.mvc.code.ch11.mapper;

import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;
import spring.mvc.code.ch11.domain.Ch11_Persion;

public interface Ch11_PersonMapper {

    @Select("SELECT * FROM TB_CH11_PERSON WHERE ID = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="name",property="name"),
            @Result(column="sex",property="sex"),
            @Result(column="age",property="age"),
            @Result(column="card_id",property="card",
                    one=@One(
                            select="spring.mvc.code.ch11.mapper.Ch11_CardMapper.selectCardById",
                            fetchType=FetchType.EAGER))
    })
    Ch11_Persion selectPersonById(Integer id);

}
