package spring.mvc.code.ch11.test;

import org.apache.ibatis.session.SqlSession;
import spring.mvc.code.ch11.domain.Ch11_Employee;
import spring.mvc.code.ch11.factory.FKSqlSessionFactory;
import spring.mvc.code.ch11.mapper.Ch11_EmployeeMapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicSQLTest {

    public static void main(String[] args)  {
        // 定義SqlSession變量
        SqlSession sqlSession = null;
        try {
            // 創建SqlSession實例
            sqlSession = FKSqlSessionFactory.getSqlSession();
            DynamicSQLTest t = new DynamicSQLTest();
            // 獲取EmployeeMapper對像
            Ch11_EmployeeMapper em = sqlSession.getMapper(Ch11_EmployeeMapper.class);
            // 測試testSelectWhitParam方法
            t.testSelectWhitParam(em);
            // 測試testInsertEmployee方法
//			t.testInsertEmployee(em);
            // 測試testUpdateEmployee方法
//			t.testUpdateEmployee(em);
            // 測試testDeleteEmployee方法
//			t.testDeleteEmployee(em);
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

    // 根據動態參數查詢員工數據
    public void testSelectWhitParam(Ch11_EmployeeMapper em){
        // 使用Map裝載參數
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("loginname", "jack");
        param.put("password", "123456");
        // 調用selectWhitParam方法
        List<Ch11_Employee> list = em.selectWhitParam(param);
        // 查看返回結果
        System.out.println(list);
    }

    // 根據設置的屬性動態插入數據
    public void testInsertEmployee(Ch11_EmployeeMapper em){

        Ch11_Employee e = new Ch11_Employee();
        e.setLoginname("mary");
        e.setPassword("123456");
        e.setName("瑪麗");
        e.setSex("女");
        e.setAge(20);
        e.setPhone("13902019999");
        e.setSal(9800.99);
        // 注意：沒有設置state屬性，則insert語句中不會包含state列
        // e.setState("ACTIVE");
        em.insertEmployee(e);

        System.out.println("插入成功，返回id：" + e.getId());

    }

    // 根據設置的屬性動態更新數據
    public void testUpdateEmployee(Ch11_EmployeeMapper em){
        // 使用Map裝載參數
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", 5);
        // 查詢id為1的員工
        Ch11_Employee e = em.selectEmployeeWithId(param);
        // 修改員工對象的三個屬性
        e.setLoginname("update");
        e.setPassword("fkjava");
        e.setName("測試");
        // 動態更新
        em.updateEmployee(e);
    }

    // 根據設置的屬性動態刪除數據
    public void testDeleteEmployee(Ch11_EmployeeMapper em){
        // 使用Map裝載參數
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("loginname", "update");
        param.put("password", "fkjava");
        // 動態刪除
        em.deleteEmployee(param);

    }


}
