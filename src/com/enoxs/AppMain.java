package com.enoxs;


import com.enoxs.data.gen.model.AppInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;

public class AppMain {
    SqlSession sqlSession = null;

    public AppMain() {
        try (// Loading mybatis-config.xml
             InputStream is = Resources.getResourceAsStream("mybatis-config.xml")
        ) {// Init myBatis + Create SqlSessionFactory Object
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            sqlSession = sqlSessionFactory.openSession();
            // run Task
            runTaskQueryAll();
//            runTaskInsertData();
//            runTaskQueryOne();
//            runTaskUpdateOne();
//            runTaskDeleteOne();
            // Commit transaction
            sqlSession.commit();
        } catch (Exception e) {
            // Rollback transaction
            e.printStackTrace();
            sqlSession.rollback();
        } finally {
            try {// Close sqlSession
                if (sqlSession != null) sqlSession.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * int deleteByPrimaryKey(Integer id);
     * int insert(AppInfo record);
     * AppInfo selectByPrimaryKey(Integer id);
     * List<AppInfo> selectAll();
     * int updateByPrimaryKey(AppInfo record);
     */
    void runTaskQueryAll() {
        List<AppInfo> lstAppInfo = sqlSession.selectList("com.enoxs.data.gen.dao.AppInfoMapper.selectAll");
    }

    void runTaskInsertData() {
        AppInfo appInfo = new AppInfo();
        appInfo.setAppName("JavaMyBatisSE-v1.0.1");
        appInfo.setAppVersion("v1.0.1");
        appInfo.setAppDate(new Date());
        appInfo.setAppAuthor("Enoxs");
        appInfo.setAppRemark("Java MyBatis Framework Simple Example Version 1.0.1");
        int state = sqlSession.insert("com.enoxs.data.gen.dao.AppInfoMapper.insert", appInfo);
        System.out.println(" State -> " + state);
    }

    void runTaskQueryOne() {
        int id = 3;
        AppInfo appInfo = sqlSession.selectOne("com.enoxs.data.gen.dao.AppInfoMapper.selectByPrimaryKey", id);
    }

    void runTaskUpdateOne() {
        String input = "2018-10-15";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date mDate = null;
        try {
            mDate = formatter.parse(input);
        } catch (ParseException e) {
            out.println("unparseable using" + formatter);
        }
        int id = 4;
        AppInfo appInfo = sqlSession.selectOne("com.enoxs.data.gen.dao.AppInfoMapper.selectByPrimaryKey", id);
        appInfo.setAppName("PyProjSE-v1.0.1");
        appInfo.setAppVersion("v1.0.1");
        appInfo.setAppDate(mDate);
        appInfo.setAppAuthor("Enoxs");
        appInfo.setAppRemark("Python Project Simple Example Version 1.0.1");
        int state = sqlSession.update("com.enoxs.data.gen.dao.AppInfoMapper.updateByPrimaryKey", appInfo);
        out.println("State -> " + state);
    }

    void runTaskDeleteOne() {
        int id = 4;
        int state = sqlSession.delete("com.enoxs.data.gen.dao.AppInfoMapper.deleteByPrimaryKey", id);
        out.println("State -> " + state);
    }

    public static void main(String[] args) {
        new AppMain();
    }

}
