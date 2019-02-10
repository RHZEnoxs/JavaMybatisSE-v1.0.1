package spring.mvc.code.ch10.mapper;

import spring.mvc.code.ch10.domain.User;

public interface UserMapper {

    User selectUserById(int id);

}
