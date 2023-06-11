package com.example.lastterms.dto;

import com.example.lastterms.entity.Product;

public class ProductResponseDto {

    public ProductResponseDto(Product product) {
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    private Long number;
    private String name;
    private int price;
    private int stock;

    public ProductResponseDto(){}

    public ProductResponseDto(Long number, String name, int price, int stock) {
        this.number = number;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public static ProductResponseDtoBuilder builder() {
        return new ProductResponseDtoBuilder();
    }

    public static class ProductResponseDtoBuilder{
        private Long number;
        private String name;
        private int price;
        private int stock;

        public ProductResponseDtoBuilder number(Long number) {
            this.number = number;
            return this;
        }
        public ProductResponseDtoBuilder price(int price) {
            this.price = price;
            return this;
        }
        public ProductResponseDtoBuilder stock(int stock) {
            this.stock = stock;
            return this;
        }

        public ProductResponseDto build() {
            return new ProductResponseDto(number, name, price, stock);
        }
    }
}