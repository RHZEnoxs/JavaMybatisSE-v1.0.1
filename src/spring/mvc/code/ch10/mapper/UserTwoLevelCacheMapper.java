package spring.mvc.code.ch10.mapper;

import spring.mvc.code.ch10.domain.UserPro;


public interface UserTwoLevelCacheMapper {
    // 根據id查詢User
    UserPro selectUserById(Integer id);

    // 根據id刪除User
    void deleteUserById(Integer id);

}
