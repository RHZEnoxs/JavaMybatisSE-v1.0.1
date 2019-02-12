package spring.mvc.code.ch10.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch10.domain.Employee;
import spring.mvc.code.ch10.factory.FKSqlSessionFactory;
import spring.mvc.code.ch10.mapper.EmployeeMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DynamicSQLTest {
    public static void main(String[] args)  {

        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();

            DynamicSQLTest t = new DynamicSQLTest();

//            t.testSelectEmployeeByIdLike(sqlSession);

//			t.testSelectEmployeeByLoginLike(sqlSession);

//			t.testSelectEmployeeChoose(sqlSession);

            // 沒有使用where元素，如果沒有傳入state參數，會導致執行失敗 的例子
//			t.testFindEmployeeLike(sqlSession);

//			t.testSelectEmployeeLike(sqlSession);

//			t.testUpdateEmployeeIfNecessary(sqlSession);

//			t.testSelectEmployeeIn(sqlSession);

			t.testSelectEmployeeLikeName(sqlSession);

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

    // 測試<select id="selectEmployeeByIdLike" ...>
    public void testSelectEmployeeByIdLike(SqlSession sqlSession){
        // 獲得EmployeeMapper接口的代理對像
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        // 創建一個HashMap存儲參數
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 設置id屬性
        params.put("id", 1);
        // 調用EmployeeMapper接口的selectEmployeeByIdLike方法
        List<Employee> list = em.selectEmployeeByIdLike(params);
        // 查看返回結果
        list.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeByLoginLike(SqlSession sqlSession){
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 設置loginname和password屬性
        params.put("loginname", "jack");
        params.put("password", "123456");
        List<Employee> list = em.selectEmployeeByLoginLike(params);
        list.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeChoose(SqlSession sqlSession){
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 設置id屬性
        params.put("id", 1);
        params.put("loginname", "jack");
        params.put("password", "123456");
        List<Employee> list = em.selectEmployeeChoose(params);
        list.forEach(employee -> System.out.println(employee));
    }

    // 沒有使用where元素，如果沒有傳入state參數，會導致執行失敗 的例子
    public void testFindEmployeeLike(SqlSession sqlSession){
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id", 1);
        params.put("loginname", "jack");
        params.put("password", "123456");
        List<Employee> list = em.findEmployeeLike(params);
        list.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeLike(SqlSession sqlSession){
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        HashMap<String, Object> params = new HashMap<String, Object>();
        // 設置state屬性和id屬性
        params.put("id", 1);
        params.put("loginname", "jack");
        params.put("password", "123456");
        List<Employee> list = em.selectEmployeeLike(params);
        list.forEach(employee -> System.out.println(employee));
    }

    public void testUpdateEmployeeIfNecessary(SqlSession sqlSession){
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = em.selectEmployeeWithId(4);
        // 設置需要修改的屬性
        employee.setLoginname("mary");
        employee.setPassword("123");
        employee.setName("瑪莉蓮");
        em.updateEmployeeIfNecessary(employee);
    }

    public void testSelectEmployeeIn(SqlSession sqlSession){
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        // 創建List集合
        List<Integer> ids = new ArrayList<Integer>();
        // 往List集合中添加兩個測試數據
        ids.add(1);
        ids.add(2);
        List<Employee> list = em.selectEmployeeIn(ids);
        list.forEach(employee -> System.out.println(employee));
    }

    public void testSelectEmployeeLikeName(SqlSession sqlSession){
        EmployeeMapper em = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        // 設置模糊查詢的參數
        employee.setName("o");
        List<Employee> list = em.selectEmployeeLikeName(employee);
        list.forEach(result -> System.out.println(result));
    }


}
