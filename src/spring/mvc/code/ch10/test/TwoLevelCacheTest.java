package spring.mvc.code.ch10.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch10.domain.UserPro;
import spring.mvc.code.ch10.factory.FKSqlSessionFactory;
import spring.mvc.code.ch10.mapper.UserTwoLevelCacheMapper;

public class TwoLevelCacheTest {

    public static void main(String[] args)  {
        // 使用工廠類獲得SqlSession對像
        SqlSession sqlSession1 = FKSqlSessionFactory.getSqlSession();
        // 獲得UserMapping對像
        UserTwoLevelCacheMapper um = sqlSession1.getMapper(UserTwoLevelCacheMapper.class);
        // 查詢id為1的User對象，會執行select語句
        UserPro user = um.selectUserById(1);
        System.out.println(user);
        // 關閉一級緩存
        sqlSession1.close();
        // 重新獲取一級緩存
        SqlSession sqlSession2 = FKSqlSessionFactory.getSqlSession();
        // 再次獲得UserMapping對像
        um = sqlSession2.getMapper(UserTwoLevelCacheMapper.class);
        // 再次查詢id為1的User對象，雖然現在使用的是一個新的SqlSession對像,但是二級緩存中緩存了數據，所以不會執行再次select語句
        UserPro user2 = um.selectUserById(1);
        System.out.println(user2);
        // 關閉SqlSession對像
        sqlSession2.close();
    }
}
