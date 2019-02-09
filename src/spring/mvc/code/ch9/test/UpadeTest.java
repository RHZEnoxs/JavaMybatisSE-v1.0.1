package spring.mvc.code.ch9.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch9.domain.User;
import spring.mvc.code.ch9.factory.FKSqlSessionFactory;

public class UpadeTest {
    public static void main(String[] args)  {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            // 根據id查詢User對象
            User user = sqlSession.selectOne("spring.mvc.code.ch9.mapper.UserMapper.selectUser",9);
            // 修改User對象的屬性值
            user.setName("tom");
            user.setAge(25);
            // 修改User對象
            sqlSession.update("spring.mvc.code.ch9.mapper.UserMapper.modifyUser", user);
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
