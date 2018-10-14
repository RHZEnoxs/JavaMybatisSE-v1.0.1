package com.enoxs.task;

import com.enoxs.data.gen.model.AppInfo;
import com.enoxs.factory.DbSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static java.lang.System.out;

public class Task1 {
    SqlSession sqlSession = null;
    public Task1(){
        sqlSession = DbSqlSessionFactory.getSqlSession();
        try{
            runDemo();
            sqlSession.commit();
        }catch(Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally{
            if(sqlSession != null) sqlSession.close();
        }
    }

    /**
     * Query 查詢
     * Save 儲存
     * Modify 修改
     * Remove 移除
     */
    void runDemo(){
        List<AppInfo> lstAppInfo = sqlSession.selectList("com.enoxs.data.gen.dao.AppInfoMapper.selectAll");
    }

    public static void main(String[] args){
        new Task1();
    }
}
