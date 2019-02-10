package spring.mvc.code.ch10.mapper;

import spring.mvc.code.ch10.domain.Student;

public interface StudentMapper {
    // 根據id查詢學生信息
    Student selectStudentById(Integer id);
}
