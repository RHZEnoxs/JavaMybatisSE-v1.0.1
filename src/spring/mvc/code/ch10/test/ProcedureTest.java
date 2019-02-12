package spring.mvc.code.ch10.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch10.domain.UserPro;
import spring.mvc.code.ch10.factory.FKSqlSessionFactory;
import spring.mvc.code.ch10.mapper.UserProMapper;

import java.util.List;

public class ProcedureTest {
    public static void main(String[] args)  {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            ProcedureTest t = new ProcedureTest();
            // 測試插入數據
//			t.testSaveUser(sqlSession);
            // 測試查詢所有數據
//			t.testSelectUser(sqlSession);
            // 測試根據id查詢對應的數據
//			t.testSelectUserById(sqlSession);
            // 測試修改數據
//			t.testModifyUser(sqlSession);
            // 測試刪除數據
            t.testRemoveUser(sqlSession);
            // 提交事務
            sqlSession.commit();
        } catch (Exception e) {
            // 回滾事務
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            // 關閉SqlSession
            if(sqlSession != null)
                sqlSession.close();
        }
    }

    // 測試插入數據
    public void testSaveUser(SqlSession sqlSession){
        // 獲得UserMapper接口的代理對像
        UserProMapper um = sqlSession.getMapper(UserProMapper.class);
        UserPro user = new UserPro("test","男",23);
//		User user = new User("jack","男",20);
//		User user = new User("rose","女",18);
//		User user = new User("tom","男",21);
//		User user = new User("mary","女",19);
//		User user = new User("alice","女",18);
//		User user = new User("scott","男",25);
        // 調用保存User的方法
        um.saveUser(user);
        System.out.println("插入成功，返回的id = " + user.getId());
    }

    // 測試查詢所有數據
    public void testSelectUser(SqlSession sqlSession){
        // 獲得UserMapper接口的代理對像
        UserProMapper um = sqlSession.getMapper(UserProMapper.class);
        // 調用查詢所有User數據的方法
        List<UserPro> users = um.selectUser();
        // 遍歷打印每一個User對像
        users.forEach(user -> System.out.println(user));
    }

    // 測試根據id查詢對應的數據
    public void testSelectUserById(SqlSession sqlSession){
        // 獲得UserMapper接口的代理對像
        UserProMapper um = sqlSession.getMapper(UserProMapper.class);
        // 調用根據id查詢User數據的方法
        UserPro user = um.selectUserById(1);
        System.out.println(user);
    }

    // 測試修改數據
    public void testModifyUser(SqlSession sqlSession){
        // 獲得UserMapper接口的代理對像
        UserProMapper um = sqlSession.getMapper(UserProMapper.class);
        // 查詢出id為1的User對像
        UserPro user = um.selectUserById(1);
        // 修改對象的屬性
        user.setName("fkit");
        user.setSex("男");
        user.setAge(19);
        // 調用修改數據的方法
        um.modifyUser(user);
    }

    // 測試刪除數據
    public void testRemoveUser(SqlSession sqlSession){
        // 獲得UserMapper接口的代理對像
        UserProMapper um = sqlSession.getMapper(UserProMapper.class);
        // 查詢出id為1的User對像
        UserPro user = um.selectUserById(1);
        // 調用刪除數據的方法
        um.removeUser(user);
    }
}
