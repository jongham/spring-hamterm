package com.example.lastterms.repository;

import com.example.lastterms.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QProductRespository extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product> {
}