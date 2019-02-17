package spring.mvc.code.ch11.mapper;


import org.apache.ibatis.annotations.*;
import spring.mvc.code.ch11.domain.Ch11_Employee;

import java.util.List;
import java.util.Map;

public interface Ch11_EmployeeMapper {

    // 動態查詢
    @SelectProvider(type=EmployeeDynaSqlProvider.class,method="selectWhitParam")
    List<Ch11_Employee> selectWhitParam(Map<String, Object> param);

    // 動態插入
    @InsertProvider(type=EmployeeDynaSqlProvider.class,method="insertEmployee")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertEmployee(Ch11_Employee employee);

    // 根據id查詢
    @SelectProvider(type=EmployeeDynaSqlProvider.class,method="selectWhitParam")
    Ch11_Employee selectEmployeeWithId(Map<String, Object> param);

    // 動態更新
    @UpdateProvider(type=EmployeeDynaSqlProvider.class,method="updateEmployee")
    void updateEmployee(Ch11_Employee employee);

    // 動態刪除
    @DeleteProvider(type=EmployeeDynaSqlProvider.class,method="deleteEmployee")
    void deleteEmployee(Map<String, Object> param);

}
