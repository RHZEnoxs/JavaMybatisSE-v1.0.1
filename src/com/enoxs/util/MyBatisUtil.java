package com.enoxs.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisUtil {
    public static SqlSession sqlSession = null;
    public static void start(String xmlConfig){
        try (InputStream is = Resources.getResourceAsStream(xmlConfig)) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(is);
            sqlSession = sqlSessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
            sqlSession.rollback();
        }
    }
    public static void done(){
        try {
            sqlSession.commit();
            if (sqlSession != null) {
                sqlSession.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
