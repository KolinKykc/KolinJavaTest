package com.kolinjavatest.kolinjavatest.controller;


import com.kolinjavatest.kolinjavatest.dto.OrderDto;
import com.kolinjavatest.kolinjavatest.dto.OrderRequestDto;
import com.kolinjavatest.kolinjavatest.dto.OrderResponseDto;
import com.kolinjavatest.kolinjavatest.model.Order;
import com.kolinjavatest.kolinjavatest.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, OrderRequestDto orderRequestDto) {
        orderService.updateOrder(id, orderRequestDto);
        return new ResponseEntity<>("updated", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderRequestDto orderDto) {
        orderService.createOrder(orderDto);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrder(@PathVariable Long id) {
        return status(HttpStatus.OK).body(orderService.getOrderById(id));
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        return status(HttpStatus.OK).body(orderService.getAllOrders());
    }

}
