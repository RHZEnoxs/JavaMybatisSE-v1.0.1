package spring.mvc.code.ch10.domain;

import java.io.Serializable;
import java.util.List;

public class Clazz implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id; // 班級id，主鍵
    private String code; // 班級編號
    private String name; // 班級名稱

    // 班級和學生是一對多的關係，即一個班級可以有多個學生
    private List<Student> students;

    public Clazz() {
        super();
        // TODO Auto-generated constructor stub
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    @Override
    public String toString() {
        return "Clazz [id=" + id + ", code=" + code + ", name=" + name + "]";
    }
}
