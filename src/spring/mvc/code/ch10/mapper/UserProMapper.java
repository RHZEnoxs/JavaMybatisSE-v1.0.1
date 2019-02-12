package spring.mvc.code.ch10.mapper;

import spring.mvc.code.ch10.domain.UserPro;

import java.util.List;

public interface UserProMapper {

    /**
     * 插入數據
     * @param user 包含要查詢的User信息
     */
    void saveUser(UserPro user);

    /**
     * 查詢所有數據
     * @return List<User> 包含所有User數據的List集合
     */
    List<UserPro> selectUser();

    /**
     * 根據id查詢對應的數據
     * @param id 用戶的id
     * @return User 包含用戶信息的User對像
     */
    UserPro selectUserById(Integer id);

    /**
     * 修改數據
     * @param user 包含要修改的User信息
     */
    void modifyUser(UserPro user);

    /**
     * 刪除數據
     * @param user 包含要修改的User信息
     */
    void removeUser(UserPro user);

}
