package spring.mvc.code.ch11.domain;

import java.io.Serializable;

public class Ch11_Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id; // 學生id，主鍵
    private String name; // 姓名
    private String sex;  // 性別
    private Integer age; // 年齡

    // 學生和班級是多對一的關係，即一個學生只屬於一個班級
    private Ch11_Clazz clazz;

    public Ch11_Student() {
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

    public Ch11_Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Ch11_Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", sex=" + sex
                + ", age=" + age + "]";
    }
}
