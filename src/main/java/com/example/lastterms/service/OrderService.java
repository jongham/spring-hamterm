package com.example.lastterms.service;

import com.example.lastterms.dto.OrderDto;
import com.example.lastterms.dto.OrderResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {

    OrderResponseDto getOrder(Long id);
    OrderResponseDto saveOrder(OrderDto orderDto);


    List<OrderResponseDto> orderList();

    OrderResponseDto getOrderByUserName(String userName);

    OrderResponseDto getOrderByUserId(Long userId);

    List<OrderResponseDto> orderList(Long id);

    OrderResponseDto getOrderByProductId(Long productId);


    List<OrderResponseDto> selectOrderByProductId(Long productId);

    List<OrderResponseDto> selectOrderByUserId(Long userId);
}
