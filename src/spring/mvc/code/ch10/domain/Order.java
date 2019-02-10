package spring.mvc.code.ch10.domain;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;  // 訂單id，主鍵
    private String code;  // 訂單編號
    private Double total; // 訂單總金額

    // 訂單和用戶是多對一的關係，即一個訂單只屬於一個用戶
    private User user;

    // 訂單和商品是多對多的關係，即一個訂單可以包含多種商品
    private List<Article> articles;

    public Order() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Order(String code, Double total) {
        super();
        this.code = code;
        this.total = total;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", code=" + code + ", total=" + total + "]";
    }

}
