package spring.mvc.code.ch10.domain;

import java.io.Serializable;
import java.util.List;

public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;		// 商品id，主鍵
    private String name;	// 商品名稱
    private Double price;	// 商品價格
    private String remark;	// 商品描述

    // 商品和訂單是多對多的關係，即一種商品可以包含在多個訂單中
    private List<Order> orders;

    public Article() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Article(String name, Double price, String remark) {
        super();
        this.name = name;
        this.price = price;
        this.remark = remark;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Article [id=" + id + ", name=" + name + ", price=" + price
                + ", remark=" + remark + "]";
    }

}
