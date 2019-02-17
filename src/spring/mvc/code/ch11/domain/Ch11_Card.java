package spring.mvc.code.ch11.domain;

import java.io.Serializable;

public class Ch11_Card implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;  // 主鍵id
    private String code; // 身份證編號

    public Ch11_Card() {
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
    @Override
    public String toString() {
        return "Card [id=" + id + ", code=" + code + "]";
    }

}
