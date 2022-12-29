package com.kolinjavatest.kolinjavatest.service;

import com.kolinjavatest.kolinjavatest.dto.OrderDto;

public interface OrderService {

    void createOrder(OrderDto orderDto);

    void updateOrder(Long id,OrderDto orderDto);

    void deleteOrder(Long id);
}
