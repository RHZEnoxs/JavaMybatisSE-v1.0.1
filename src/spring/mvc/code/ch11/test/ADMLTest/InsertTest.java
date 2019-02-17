package spring.mvc.code.ch11.test.ADMLTest;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch11.domain.Ch11_User;
import spring.mvc.code.ch11.factory.FKSqlSessionFactory;
import spring.mvc.code.ch11.mapper.Ch11_UserMapper;

public class InsertTest {
    public static void main(String[] args) {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();

            // 創建UserMapper實例
            Ch11_UserMapper um = sqlSession.getMapper(Ch11_UserMapper.class);
            // 創建User對象並設置屬性
            Ch11_User user = new Ch11_User();
            user.setName("test");
            user.setSex("男");
            user.setAge(18);
            // 插入數據
            um.saveUser(user);
            // 查看插入數據生成的主鍵
            System.out.println("插入數據生成的主鍵id為：" + user.getId());

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
}
