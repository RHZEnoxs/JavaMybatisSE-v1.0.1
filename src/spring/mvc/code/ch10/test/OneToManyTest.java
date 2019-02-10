package spring.mvc.code.ch10.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch10.domain.Clazz;
import spring.mvc.code.ch10.domain.Student;
import spring.mvc.code.ch10.factory.FKSqlSessionFactory;
import spring.mvc.code.ch10.mapper.ClazzMapper;
import spring.mvc.code.ch10.mapper.StudentMapper;

import java.util.List;

public class OneToManyTest {

    public static void main(String[] args) {

        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            OneToManyTest t = new OneToManyTest();
            t.testSelectClazzById(sqlSession);
			t.testSelectStudentById(sqlSession);
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

    // 測試一對多，查詢班級Clazz（一）的時候級聯查詢學生Student（多）
    public void testSelectClazzById(SqlSession sqlSession){
        // 獲得ClazzMapper接口的代理對像
        ClazzMapper cm = sqlSession.getMapper(ClazzMapper.class);
        // 調用selectClazzById方法
        Clazz clazz = cm.selectClazzById(1);
        // 查看查詢到的clazz對像信息
        System.out.println(clazz.getId() + " "+ clazz.getCode() + " "+clazz.getName());
        // 查看clazz對像關聯的學生信息
        List<Student> students = clazz.getStudents();
        students.forEach(stu -> System.out.println(stu));
    }

    // 測試多對一，查詢學生Student（多）的時候級聯查詢 班級Clazz（一）
    public void testSelectStudentById(SqlSession sqlSession){
        // 獲得StudentMapper接口的代理對像
        StudentMapper sm = sqlSession.getMapper(StudentMapper.class);
        // 調用selectStudentById方法
        Student stu = sm.selectStudentById(1);
        // 查看查詢到的Student對像信息
        System.out.println(stu);
        // 查看Student對像關聯的班級信息
        System.out.println(stu.getClazz());
    }

}
