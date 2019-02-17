package spring.mvc.code.ch11.mapper;

import org.apache.ibatis.annotations.Select;
import spring.mvc.code.ch11.domain.Ch11_Card;

public interface Ch11_CardMapper {


    @Select("SELECT * FROM TB_CH11_CARD WHERE ID = #{id} ")
    Ch11_Card selectCardById(Integer id);

}
