package com.example.lastterms.controller;

import com.example.lastterms.dto.OrderDto;
import com.example.lastterms.dto.OrderResponseDto;
import com.example.lastterms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/insert")
    public ResponseEntity<OrderResponseDto> saveOrder(@RequestBody OrderDto orderDto) throws Exception {
        OrderResponseDto orderResponseDto = orderService.saveOrder(orderDto);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<OrderResponseDto>> allOrder() {
        List<OrderResponseDto> orderResponseDto = orderService.orderList();
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }

    @GetMapping("/listByUserId")
    public ResponseEntity<List<OrderResponseDto>> OrderByUserId(Long UserId) {
        List<OrderResponseDto> orderResponseDto = orderService.selectOrderByUserId(UserId);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }

    @GetMapping("/listByProductId")
    public ResponseEntity<List<OrderResponseDto>> OrderByProductId(Long ProductId) {
        List<OrderResponseDto> orderResponseDto = orderService.selectOrderByProductId(ProductId);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }

    @GetMapping("/")
    public ResponseEntity<OrderResponseDto> getOrder(Long id) {
        OrderResponseDto orderResponseDto = orderService.getOrder(id);
        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDto);
    }
}
