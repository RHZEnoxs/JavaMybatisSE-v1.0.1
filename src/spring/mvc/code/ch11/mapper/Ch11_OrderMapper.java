package spring.mvc.code.ch11.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import spring.mvc.code.ch11.domain.Ch11_Order;

public interface Ch11_OrderMapper {
    @Select("SELECT * FROM TB_CH11_ORDER WHERE ID = #{id}")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="code",property="code"),
            @Result(column="total",property="total"),
            @Result(column="user_id",property="user",
                    one=@One(select="spring.mvc.code.ch11.mapper.Ch11_ManyToManyUserMapper.selectById",
                            fetchType=FetchType.EAGER)),
            @Result(column="id",property="articles",
                    many=@Many(select="spring.mvc.code.ch11.mapper.Ch11_ArticleMapper.selectByOrderId",
                            fetchType=FetchType.LAZY))
    })
    Ch11_Order selectById(Integer id);
}
