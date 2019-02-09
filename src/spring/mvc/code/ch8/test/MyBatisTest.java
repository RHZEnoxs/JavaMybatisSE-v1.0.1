package spring.mvc.code.ch8.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import spring.mvc.code.ch8.domain.User;

import java.io.InputStream;

public class MyBatisTest {

    public static void main(String[] args) {
        // 創建Session實例
        SqlSession sqlSession = null;
        try (// 讀取mybatis-config.xml文件
             InputStream is = Resources.getResourceAsStream("mybatis-config.xml")
        ){
            // 初始化mybatis，創建SqlSessionFactory類的實例
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);
            sqlSession = sqlSessionFactory.openSession();
            // 創建User對象
            User user = new User("admin", "男", 26);
            // 插入數據
            sqlSession.insert("spring.mvc.code.ch8.mapper.UserMapper.save", user);
            // 提交事務
            sqlSession.commit();
        } catch (Exception e) {
            // 回滾事務
            sqlSession.rollback();
            e.printStackTrace();
        }finally{
            try {
                // 關閉sqlSession
                if(sqlSession != null) sqlSession.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
