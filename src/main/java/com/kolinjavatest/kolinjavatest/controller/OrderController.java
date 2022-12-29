package com.kolinjavatest.kolinjavatest.controller;


import com.kolinjavatest.kolinjavatest.dto.OrderDto;
import com.kolinjavatest.kolinjavatest.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, OrderDto orderDto) {
        orderService.updateOrder(id, orderDto);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody OrderDto orderDto) {
        orderService.createOrder(orderDto);
        return new ResponseEntity<>("created", HttpStatus.OK);
    }
    /*for get all orders
    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<OrderDto>> findAllOrders() {
        List<OrderDto> orders = orderService.;

        return new ResponseEntity<>(orderService, HttpStatus.OK);
    }*/

}
