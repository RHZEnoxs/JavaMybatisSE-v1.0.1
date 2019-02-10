package spring.mvc.code.ch10.domain;

import java.io.Serializable;

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;  // 主鍵id
    private String name; // 姓名
    private String sex;  // 性別
    private Integer age; // 年齡

    // 人和身份證是一對一的關係，即一個人只有一個身份證
    private Card card;

    public Person() {
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", sex=" + sex
                + ", age=" + age + "]";
    }
}
