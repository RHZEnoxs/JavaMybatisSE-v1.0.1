package spring.mvc.code.ch11.domain;

import java.io.Serializable;

public class Ch11_User_Pro implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String sex;
    private Integer age;

    public Ch11_User_Pro() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Ch11_User_Pro( String name, String sex, Integer age) {
        super();
        this.name = name;
        this.sex = sex;
        this.age = age;
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

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", sex=" + sex + ", age="
                + age + "]";
    }

}
