package spring.mvc.code.ch10.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch10.domain.Article;
import spring.mvc.code.ch10.domain.Order;
import spring.mvc.code.ch10.domain.User;
import spring.mvc.code.ch10.factory.FKSqlSessionFactory;
import spring.mvc.code.ch10.mapper.OrderMapper;
import spring.mvc.code.ch10.mapper.UserMapper;

import java.util.List;

public class ManyToManyTest {

    public static void main(String[] args)  {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            ManyToManyTest t = new ManyToManyTest();
            // 根據用戶id查詢用戶，測試一對多
//            t.testSelectUserById(sqlSession);
            // 根據訂單id查詢訂單，測試多對多
			t.testSelectOrderById(sqlSession);
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

    // 測試一對多，查詢班級User（一）的時候級聯查詢訂單Order（多）
    public void testSelectUserById(SqlSession sqlSession){
        // 獲得UserMapper接口的代理對像
        UserMapper um = sqlSession.getMapper(UserMapper.class);
        // 調用selectUserById方法
        User user = um.selectUserById(1);
        // 查看查詢到的user對像信息
        System.out.println(user.getId() + " " + user.getUsername());
        // 查看user對像關聯的訂單信息
        List<Order> orders = user.getOrders();
        orders.forEach(order -> System.out.println(order));
    }

    // 測試多對多，查詢訂單Order（多）的時候級聯查詢訂單的商品Article（多）
    public void testSelectOrderById(SqlSession sqlSession){
        // 獲得OrderMapper接口的代理對像
        OrderMapper om = sqlSession.getMapper(OrderMapper.class);
        // 調用selectOrderById方法
        Order order = om.selectOrderById(2);
        // 查看查詢到的order對像信息
        System.out.println(order.getId() + " " + order.getCode() + " " + order.getTotal());
        // 查看order對像關聯的用戶信息
        User user = order.getUser();
        System.out.println(user);
        // 查看order對像關聯的商品信息
        List<Article> articles = order.getArticles();
        articles.forEach(article -> System.out.println(article));
    }

}
