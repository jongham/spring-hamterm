package com.example.lastterms.dao.impl;

import com.example.lastterms.dao.OrderDAO;
import com.example.lastterms.dto.OrderDto;
import com.example.lastterms.dto.OrderResponseDto;
import com.example.lastterms.entity.Order;
import com.example.lastterms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @Override
    public OrderResponseDto getOrder(Long id) {
        Order order = orderDAO.selectOrder(id);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setPrice(order.getPrice());
        orderResponseDto.setId(order.getId());
        orderResponseDto.setUserName(order.getUserName());
        orderResponseDto.setUserId(order.getUserId());
        orderResponseDto.setProductId(order.getProductId());
        orderResponseDto.setProductId(order.getProductId());

        return orderResponseDto;
    }

    @Override
    public OrderResponseDto saveOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setUserId(orderDto.getUserId());
        order.setPrice(orderDto.getPrice());
        order.setUserName(orderDto.getUserName());
        order.setProductId(orderDto.getProductId());
        order.setProductName(orderDto.getProductName());
        order.setCreatedAt(LocalDateTime.now());
        order.setUpdatedAt(LocalDateTime.now());

        Order saveOrder = orderDAO.insertOrder(order);

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setProductId(saveOrder.getProductId());
        orderResponseDto.setProductName(saveOrder.getProductName());
        orderResponseDto.setPrice(saveOrder.getPrice());
        orderResponseDto.setUserId(saveOrder.getUserId());
        orderResponseDto.setUserName(saveOrder.getUserName());
        return orderResponseDto;

    }

    @Override
    public List<OrderResponseDto> orderList() {
        return null;
    }

    @Override
    public OrderResponseDto getOrderByUserName(String userName) {
        return null;
    }

    @Override
    public OrderResponseDto getOrderByUserId(Long userId) {
        return null;
    }


    @Override
    public List<OrderResponseDto> orderList(Long id) {

        List<Order> allList = orderDAO.allOrder(id);
        List<OrderResponseDto> result = allList.stream().map(OrderResponseDto::new).collect(Collectors.toList());

        return result;
    }

    @Override
    public OrderResponseDto getOrderByProductId(Long productId) {
        return null;
    }

    @Override
    public List<OrderResponseDto> selectOrderByProductId(Long productId) {

        List<Order> allList = orderDAO.selectOrderByProductId(productId);
        List<OrderResponseDto> result = allList.stream().map(OrderResponseDto::new).collect(Collectors.toList());

        return result;
    }

    @Override
    public List<OrderResponseDto> selectOrderByUserId(Long userId) {

        List<Order> allList = orderDAO.selectOrderByUserId(userId);
        List<OrderResponseDto> result = allList.stream().map(OrderResponseDto::new).collect(Collectors.toList());

        return result;
    }

}
