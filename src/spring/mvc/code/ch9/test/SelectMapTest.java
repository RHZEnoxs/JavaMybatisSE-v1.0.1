package spring.mvc.code.ch9.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch9.factory.FKSqlSessionFactory;

import java.util.List;
import java.util.Map;

public class SelectMapTest {
    public static void main(String[] args) {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            // 查詢TB_USER表所有數據返回List集合,集合中的每個元素都是一個Map
            List<Map<String,Object>> list
                    = sqlSession.selectList("spring.mvc.code.ch9.mapper.ResultMapMapper.selectUser");
            // 遍歷List集合，打印每一個Map對象
            list.forEach(row -> System.out.println(row));
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
