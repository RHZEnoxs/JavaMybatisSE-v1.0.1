package spring.mvc.code.ch10.mapper;

import spring.mvc.code.ch10.domain.Clazz;

public interface ClazzMapper {
    // 根據id查詢班級信息
    Clazz selectClazzById(Integer id);
}
