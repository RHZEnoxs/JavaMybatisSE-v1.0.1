package spring.mvc.code.ch11.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch11.domain.Ch11_Clazz;
import spring.mvc.code.ch11.factory.FKSqlSessionFactory;
import spring.mvc.code.ch11.mapper.Ch11_ClazzMapper;

public class OneToManyTest {
    public static void main(String[] args) {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            // 獲取ClazzMapper實例
            Ch11_ClazzMapper cm = sqlSession.getMapper(Ch11_ClazzMapper.class);
            // 根據id查詢Clazz對像
            Ch11_Clazz clazz = cm.selectById(1);
            // 查看查詢到的Clazz對像
            System.out.println(clazz.getId() + " "+ clazz.getCode() + " "+clazz.getName());
            // 查看關聯的學生集合，因為配置使用的是LAZY懶加載，所以當使用時才執行SQL語句
            clazz.getStudents().forEach(student->System.out.println(student));
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
