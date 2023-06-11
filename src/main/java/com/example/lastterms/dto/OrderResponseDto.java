package com.example.lastterms.dto;

import com.example.lastterms.entity.Order;

public class OrderResponseDto {

    public OrderResponseDto(Order order) {
    }


    private  Long id;

    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    private String productName;


    private Long userId;


    private String userName;


    private int price;

    public OrderResponseDto(){}

    public OrderResponseDto(Long id, Long productId, String productName, Long userId, int price,String userName) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.userId = userId;
        this.userName = userName;
    }

    public static OrderResponseDtoBuilder builder() {
        return new OrderResponseDtoBuilder();
    }

    public static class OrderResponseDtoBuilder{
        private  Long id;

        private Long productId;


        private String productName;


        private Long userId;


        private String userName;


        private int price;

        public OrderResponseDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public OrderResponseDtoBuilder price(int price) {
            this.price = price;
            return this;
        }
        public OrderResponseDtoBuilder productId(long productId ) {
            this.productId = productId;
            return this;
        }

        public OrderResponseDtoBuilder userId(long userId ) {
            this.userId = userId;
            return this;
        }

        public OrderResponseDtoBuilder productName(String productName ) {
            this.productName = productName;
            return this;
        }

        public OrderResponseDtoBuilder userName(String userName ) {
            this.userName = userName;
            return this;
        }

        public OrderResponseDto build() {
            return new OrderResponseDto(id, productId,userName,userId, price,productName);
        }
    }
}
