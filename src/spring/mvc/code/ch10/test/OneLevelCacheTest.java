package spring.mvc.code.ch10.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch10.domain.UserPro;
import spring.mvc.code.ch10.factory.FKSqlSessionFactory;
import spring.mvc.code.ch10.mapper.UserOneLevelCacheMapper;

public class OneLevelCacheTest {

    public static void main(String[] args)  {

        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            OneLevelCacheTest t = new OneLevelCacheTest();

//			t.testCache1(sqlSession);
//			t.testCache2(sqlSession);
//			t.testCache3(sqlSession);
            t.testCache4();

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

    /*
     * 一級緩存: 也就Session級的緩存(默認開啟)
     */
    public void testCache1 (SqlSession sqlSession){
        // 獲得UserMapping對像
        UserOneLevelCacheMapper um = sqlSession.getMapper(UserOneLevelCacheMapper.class);
        // 查詢id為1的User對象，會執行select語句
        UserPro user = um.selectUserById(1);
        System.out.println(user);
        // 再次查詢id為1的User對像,因為是同一個SqlSession,所以會從之前的一級緩存中查找數據
        UserPro user2 = um.selectUserById(1);
        System.out.println(user2);
    }

    // 測試一級緩存執行DML語句並提交
    public void testCache2 (SqlSession sqlSession){
        // 獲得UserMapping對像
        UserOneLevelCacheMapper um = sqlSession.getMapper(UserOneLevelCacheMapper.class);
        // 查詢id為1的User對象，會執行select語句
        UserPro user = um.selectUserById(1);
        System.out.println(user);
        // 執行delete操作
        um.deleteUserById(5);
        // commit提交
        sqlSession.commit();
        // 再次查詢id為1的User對像,因為DML操作會清空SqlSession緩存,所以會再次執行select語句
        UserPro user2 = um.selectUserById(1);
        System.out.println(user2);
    }

    // 測試一級緩存clearCache
    public void testCache3 (SqlSession sqlSession){
        // 獲得UserMapping對像
        UserOneLevelCacheMapper um = sqlSession.getMapper(UserOneLevelCacheMapper.class);
        // 查詢id為1的User對象，會執行select語句
        UserPro user = um.selectUserById(1);
        System.out.println(user);
        // 清空一級緩存
        sqlSession.clearCache();
        // 再次獲得UserMapping對像
        um = sqlSession.getMapper(UserOneLevelCacheMapper.class);
        // 再次訪問，因為SqlSession一級緩存已經清空,所以會再次執行select語句
        UserPro user2 = um.selectUserById(1);
        System.out.println(user2);
    }

    // 測試一級緩存close
    public void testCache4 (){
        // 使用工廠類獲得SqlSession對像
        SqlSession sqlSession = FKSqlSessionFactory.getSqlSession();
        // 獲得UserMapping對像
        UserOneLevelCacheMapper um = sqlSession.getMapper(UserOneLevelCacheMapper.class);
        // 查詢id為1的User對象，會執行select語句
        UserPro user = um.selectUserById(1);
        System.out.println(user);
        // 關閉一級緩存
        sqlSession.close();
        // 再次訪問,重新獲取一級緩存，然後才能查找數據，否則會拋出異常
        SqlSession sqlSession2 = FKSqlSessionFactory.getSqlSession();
        // 再次獲得UserMapping對像
        um = sqlSession2.getMapper(UserOneLevelCacheMapper.class);
        // 再次訪問，因為現在使用的是一個新的SqlSession對像,所以會再次執行select語句
        UserPro user2 = um.selectUserById(1);
        System.out.println(user2);
        // 關閉SqlSession對像
        sqlSession2.close();
    }
}
