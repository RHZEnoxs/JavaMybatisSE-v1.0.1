package spring.mvc.code.ch9.domain;

import java.io.Serializable;
import java.util.List;

public class Clazz implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String code;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Clazz [id=" + id + ", code=" + code + "]";
    }
}
