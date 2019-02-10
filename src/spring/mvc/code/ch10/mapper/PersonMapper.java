package spring.mvc.code.ch10.mapper;

import spring.mvc.code.ch10.domain.Person;

public interface PersonMapper {

    /**
     * 根據id查詢Person
     * 方法名和參數必須和XML文件中的<select.../>元素的id屬性和parameterType屬性一致
     * @param id
     * @return Person對像
     * */
    Person selectPersonById(Integer id);
}
