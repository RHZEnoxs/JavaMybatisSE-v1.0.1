package spring.mvc.code.ch8.domain;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    // 用戶標識
    private Integer id;
    // 用戶姓名
    private String name;
    // 用户性别
    private String sex;
    // 用戶年齡
    private Integer age;

    // 無參數構造器
    public User() {
        super();
    }
    // 有參數構造器
    public User( String name, String sex, Integer age) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    // setter和getter方法
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", age="
                + age + "]";
    }
}
