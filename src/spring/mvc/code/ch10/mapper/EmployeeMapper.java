package spring.mvc.code.ch10.mapper;

import spring.mvc.code.ch10.domain.Employee;

import java.util.HashMap;
import java.util.List;

public interface EmployeeMapper {

    List<Employee> selectEmployeeByIdLike(HashMap<String, Object> params);

    List<Employee> selectEmployeeByLoginLike(HashMap<String, Object> params);

    List<Employee> selectEmployeeChoose(HashMap<String, Object> params);

    List<Employee> findEmployeeLike(HashMap<String, Object> params);

    List<Employee> selectEmployeeLike(HashMap<String, Object> params);

    Employee selectEmployeeWithId(Integer id);

    void updateEmployeeIfNecessary(Employee employee);

    List<Employee> selectEmployeeIn(List<Integer> ids);

    List<Employee> selectEmployeeLikeName(Employee employee);

}
