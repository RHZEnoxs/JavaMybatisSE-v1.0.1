package spring.mvc.code.ch11.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch11.domain.Ch11_Persion;
import spring.mvc.code.ch11.factory.FKSqlSessionFactory;
import spring.mvc.code.ch11.mapper.Ch11_PersonMapper;

public class OneToOneTest {

    public static void main(String[] args) {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            // 獲取PersonMapper實例
            Ch11_PersonMapper pm = sqlSession.getMapper(Ch11_PersonMapper.class);
            // 根據id查詢Person對象，同時需要獲得關聯的Card對像
            Ch11_Persion p = pm.selectPersonById(1);
            // 查看查詢到的Person對像
            System.out.println(p);
            // 查看查詢到的關聯的Card對像
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
