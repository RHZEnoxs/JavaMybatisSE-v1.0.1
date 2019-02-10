package spring.mvc.code.ch10.factory;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class FKSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory = null;

    // 初始化創建SqlSessionFactory對象
    static{
        try (// 讀取mybatis-config.xml文件
             InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        ){
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 獲取SqlSession對象的靜態方法
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    // 獲取SqlSessionFactory的靜態方法
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
