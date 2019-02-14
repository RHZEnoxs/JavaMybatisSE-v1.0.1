package spring.mvc.code.ch10.mapper;

import spring.mvc.code.ch10.domain.UserPro;

import java.util.List;

public interface UserOneLevelCacheMapper {
    // 根據id查詢User
    UserPro selectUserById(Integer id);

    // 查詢所有User
    List<UserPro> selectAllUser();

    // 根據id刪除User
    void deleteUserById(Integer id);
}
