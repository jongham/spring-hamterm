package com.example.lastterms.service;

import com.example.lastterms.dto.ProductDto;
import com.example.lastterms.dto.ProductResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductService {

    ProductResponseDto getProduct(Long number);
    ProductResponseDto saveProduct(ProductDto productDto);

    ProductResponseDto changeProductName(Long number, String name) throws Exception;

    void deleteProduct(Long number) throws Exception;

    List<ProductResponseDto> productList();

    List<ProductResponseDto> productListOrderByProduct();

    ProductResponseDto getProductByName(String name);
}