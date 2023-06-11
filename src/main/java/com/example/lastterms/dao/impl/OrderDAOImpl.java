package com.example.lastterms.dao.impl;

import com.example.lastterms.dao.OrderDAO;

import com.example.lastterms.repository.OrderRepository;
import com.example.lastterms.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;


@Component
public class OrderDAOImpl implements OrderDAO {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderDAOImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public Order insertOrder(Order order) {
        Order saveOrder = orderRepository.save(order);
        return saveOrder;
    }



    @Override
    public Order selectOrder(Long id) {
        Order selectOrder = orderRepository.getReferenceById(id);
        return selectOrder;
    }


    @Override
    public List<Order> allOrder(Long id) {
        return orderRepository.findAllById(Collections.singleton(id));
    }

    @Override
    public List<Order> selectOrderByUserId(Long userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public List<Order> selectOrderByProductId(Long productId) {
        return orderRepository.findAllByProductId(productId);
    }

}
