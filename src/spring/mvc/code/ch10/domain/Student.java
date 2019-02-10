package spring.mvc.code.ch10.domain;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id; // 學生id，主鍵
    private String name; // 姓名
    private String sex;  // 性別
    private Integer age; // 年齡

    // 學生和班級是多對一的關係，即一個學生只屬於一個班級
    private Clazz clazz;

    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", sex=" + sex
                + ", age=" + age + "]";
    }

}
