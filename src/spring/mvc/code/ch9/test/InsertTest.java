package spring.mvc.code.ch9.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch9.domain.User;
import spring.mvc.code.ch9.factory.FKSqlSessionFactory;

public class InsertTest {

    public static void main(String[] args)  {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            // 創建User對象
            User user = new User("jack", "男", 22);
            // 插入數據
            sqlSession.insert("spring.mvc.code.ch9.mapper.UserMapper.saveUser", user);
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
