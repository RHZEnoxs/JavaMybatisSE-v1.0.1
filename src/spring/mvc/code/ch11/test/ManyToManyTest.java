package spring.mvc.code.ch11.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch11.domain.Ch11_Order;
import spring.mvc.code.ch11.factory.FKSqlSessionFactory;
import spring.mvc.code.ch11.mapper.Ch11_OrderMapper;

public class ManyToManyTest {

    public static void main(String[] args) {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            // 獲取OrderMapper實例
            Ch11_OrderMapper om = sqlSession.getMapper(Ch11_OrderMapper.class);
            // 根據id查詢Order對像
            Ch11_Order order = om.selectById(1);
            // 查看查詢到的Order對像
            System.out.println(order.getId() + " " + order.getCode() + " " + order.getTotal());
            // 查看Order關聯的User對像
            System.out.println(order.getUser());
            // 查看關聯的Article集合，因為配置使用的是LAZY懶加載，所以當使用時才執行SQL語句
            order.getArticles().forEach(article -> System.out.println(article));
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
