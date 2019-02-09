package spring.mvc.code.ch9.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch9.domain.Clazz;
import spring.mvc.code.ch9.domain.Student;
import spring.mvc.code.ch9.factory.FKSqlSessionFactory;

import java.util.List;

public class SelectClazzTest {

    public static void main(String[] args)  {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            // 查詢TB_CLAZZ表所有數據返回List集合,集合中的每個元素都是一個Clazz對象
            List<Clazz> clazz_list
                    = sqlSession.selectList("spring.mvc.code.ch9.mapper.ResultMapMapper.selectClazz");
            // 遍歷List集合，打印每一個Clazz對象和該Clazz關聯的所有Student對象
            for(Clazz clazz : clazz_list){
                System.out.println(clazz);
                List<Student> student_list = clazz.getStudents();
                for(Student stu : student_list){
                    System.out.println(stu.getId() + " " + stu.getName() + " " + stu.getSex() + " " + stu.getAge());
                }
            }
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
