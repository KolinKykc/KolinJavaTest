package com.kolinjavatest.kolinjavatest.service;

import com.kolinjavatest.kolinjavatest.dto.OrderDto;
import com.kolinjavatest.kolinjavatest.dto.OrderRequestDto;
import com.kolinjavatest.kolinjavatest.dto.OrderResponseDto;
import com.kolinjavatest.kolinjavatest.model.Order;

import java.util.List;

public interface OrderService {

    void createOrder(OrderRequestDto orderRequestDto);

    void updateOrder(Long id, OrderRequestDto orderRequestDto);

    void deleteOrder(Long id);

    OrderResponseDto getOrderById(Long id);

    List<Order> getAllOrders();

}
