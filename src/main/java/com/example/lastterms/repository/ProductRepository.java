package com.example.lastterms.repository;

import com.example.lastterms.entity.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByOrderByPriceDesc();

    List<Product> findAllByNumber(Long number);

    Product findByName(String name, Sort sort);



}