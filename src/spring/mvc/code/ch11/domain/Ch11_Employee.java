package spring.mvc.code.ch11.domain;

import java.io.Serializable;

public class Ch11_Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;			 // 主鍵id
    private String loginname;	 // 登錄名
    private String password;	 // 密碼
    private String name;		 // 真實姓名
    private String sex;			 // 性別
    private Integer age;		 // 年齡
    private String phone;		 // 電話
    private Double sal;		     // 薪水
    private String state;	 	 // 狀態

    public Ch11_Employee() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getLoginname() {
        return loginname;
    }
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public Double getSal() {
        return sal;
    }
    public void setSal(Double sal) {
        this.sal = sal;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    @Override
    public String toString() {
        return "Employee [id=" + id + ", loginname=" + loginname
                + ", password=" + password + ", name=" + name + ", sex=" + sex
                + ", age=" + age + ", phone=" + phone + ", sal=" + sal
                + ", state=" + state + "]";
    }

}
