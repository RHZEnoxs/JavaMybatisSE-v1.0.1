package spring.mvc.code.ch11.mapper;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import spring.mvc.code.ch11.domain.Ch11_User_Pro;

import java.util.List;

public interface Ch11_UserProMapper {
    /**
     * 插入數據
     * @param user 包含要查詢的User信息
     */
    @Insert("{call insert_ch11_user(#{id,mode=OUT,jdbcType=INTEGER},"
            + "#{name,mode=IN},#{sex,mode=IN},#{age,mode=IN})}")
    @Options(statementType=StatementType.CALLABLE)
    void saveUser(Ch11_User_Pro user);

    /**
     * 查詢所有數據
     * @return List<User> 包含所有User數據的List集合
     */
    @Select("{call select_ch11_user()}")
    @Options(statementType=StatementType.CALLABLE)
    List<Ch11_User_Pro> selectUser();

    /**
     * 根據id查詢對應的數據
     * @param id 用戶的id
     * @return User 包含用戶信息的User對象
     */
    @Select("{call select_ch11_user_by_id(#{id,mode=IN})}")
    @Options(statementType=StatementType.CALLABLE)
    Ch11_User_Pro selectUserById(Integer id);

    /**
     * 修改數據
     * @param user 包含要修改的User信息
     */
    @Update("{call update_ch11_user(#{id,mode=IN},#{name,mode=IN},#{sex,mode=IN},#{age,mode=IN})}")
    @Options(statementType=StatementType.CALLABLE)
    void modifyUser(Ch11_User_Pro user);

    /**
     * 刪除數據
     * @param user 包含要修改的User信息
     */
    @Delete("{call delete_ch11_user_by_id(#{id,mode=IN})}")
    @Options(statementType=StatementType.CALLABLE)
    void removeUser(Ch11_User_Pro user);

}
