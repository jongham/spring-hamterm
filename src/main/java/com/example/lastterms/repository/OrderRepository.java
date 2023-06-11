package com.example.lastterms.repository;

import com.example.lastterms.entity.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {



    List<Order> findAllByUserId(long userId);

    List<Order> findAllByProductId(long productId);

    Order findById(long id, Sort sort);



}
