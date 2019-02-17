package spring.mvc.code.ch11.test.ADMLTest;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch11.factory.FKSqlSessionFactory;
import spring.mvc.code.ch11.mapper.Ch11_UserMapper;

public class DeleteTest {
    public static void main(String[] args)  {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            // 創建UserMapper實例
            Ch11_UserMapper um = sqlSession.getMapper(Ch11_UserMapper.class);
            // 刪除User對像
            um.removeUser(5);
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
