package spring.mvc.code.ch11.mapper;

import org.apache.ibatis.annotations.Select;
import spring.mvc.code.ch11.domain.Ch11_Article;

import java.util.List;

public interface Ch11_ArticleMapper {

    @Select("SELECT * FROM tb_ch11_article WHERE id IN "
            +"(SELECT article_id FROM tb_item WHERE order_id = #{id} ) ")
    List<Ch11_Article> selectByOrderId(Integer order_id);
}
