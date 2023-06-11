package com.example.lastterms.dao;

import com.example.lastterms.entity.Product;

import java.util.List;

public interface ProductDAO {

    Product insertProduct(Product product);

    Product selectProduct(Long number);

    Product updateProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

    Product selectProductByName(String name);

    List<Product> allProduct();

    List<Product> listOrderByProduct();


}