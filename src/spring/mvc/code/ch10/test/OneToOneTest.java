package spring.mvc.code.ch10.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch10.domain.Person;
import spring.mvc.code.ch10.factory.FKSqlSessionFactory;
import spring.mvc.code.ch10.mapper.PersonMapper;

public class OneToOneTest {
    public static void main(String[] args) {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            // 獲得mapper接口的代理對像
            PersonMapper pm = sqlSession.getMapper(PersonMapper.class);
            // 直接調用接口的方法，查詢id為1的Peson數據
            Person p = pm.selectPersonById(1);
            // 打印Peson對像
            System.out.println(p);
            // 打印Person對像關聯的Card對像
            System.out.println(p.getCard());
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
