package com.enoxs.demo;

import com.enoxs.data.gen.model.AppInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class DemoTest {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static{
        try{
            reader    = Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    public SqlSession session = null;
    StringBuffer sb = new StringBuffer(512);
    public DemoTest(){
        session = sqlSessionFactory.openSession();
//        runTaskv1();
        runTaskv2();
    }
    void runTaskv1(){
        try {
            List<AppInfoDemo> lstAppInfoDemo = (List<AppInfoDemo>) session.selectList("com.enoxs.demo.AppInfoMapperDemo.selectAll");
            for(AppInfoDemo obj : lstAppInfoDemo){
                sb.append(obj.getId());
                sb.append(" : ");
                sb.append(obj.getAppName());
                sb.append(" , ");
                sb.append(obj.getAppVersion());
                sb.append(" , ");
                sb.append(obj.getAppDate());
                sb.append(" , ");
                sb.append(obj.getAppAuthor());
                sb.append(" , ");
                sb.append(obj.getAppRemark());
                sb.append(". \n");
            }
            System.out.println(sb.toString());
            System.out.println(lstAppInfoDemo.get(0).getAppName());
        } finally {
            session.close();
        }
    }
    void runTaskv2(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<AppInfo> lstAppInfo= (List<AppInfo>) session.selectList("com.enoxs.data.gen.dao.AppInfoMapper.selectAll");
            StringBuffer sb = new StringBuffer(512);
            for(AppInfo obj : lstAppInfo){
                sb.append(obj.getId());
                sb.append(" : ");
                sb.append(obj.getAppName());
                sb.append(" , ");
                sb.append(obj.getAppVersion());
                sb.append(" , ");
                sb.append(obj.getAppDate());
                sb.append(" , ");
                sb.append(obj.getAppAuthor());
                sb.append(" , ");
                sb.append(obj.getAppRemark());
                sb.append(". \n");
            }
            System.out.println(sb.toString());
            System.out.println(lstAppInfo.get(0).getAppName());
        } finally {
            session.close();
        }
    }
    public static void main(String [] args){
        new DemoTest();
    }
}
