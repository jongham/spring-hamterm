package com.example.lastterms.dao;

import com.example.lastterms.entity.Order;

import java.util.List;

public interface OrderDAO {

    Order insertOrder(Order order);

    Order selectOrder(Long id);

    List<Order> allOrder(Long id);

    List<Order> selectOrderByUserId(Long userId);

    List<Order> selectOrderByProductId(Long productId);
}
