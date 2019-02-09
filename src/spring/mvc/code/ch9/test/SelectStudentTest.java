package spring.mvc.code.ch9.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch9.domain.Student;
import spring.mvc.code.ch9.factory.FKSqlSessionFactory;

import java.util.List;

public class SelectStudentTest {
    public static void main(String[] args)  {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            // 查詢TB_USER表所有數據返回List集合,集合中的每個元素都是一個Student對象
            List<Student> student_list
                    = sqlSession.selectList("spring.mvc.code.ch9.mapper.ResultMapMapper.selectStudent");
            // 遍歷List集合，打印每一個Student對象，該對象包含關聯的Clazz對象
            student_list.forEach(stu -> System.out.println(stu));
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
