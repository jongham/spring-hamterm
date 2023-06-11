package com.example.lastterms.dto;

import javax.persistence.Column;

public class OrderDto {

    private Long productId;


    private String productName;


    private Long userId;


    private String userName;


    private int price;

    public OrderDto(Long productId, String productName, Long userId, int price,String userName) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.userId = userId;
        this.userName = userName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
