package com.kolinjavatest.kolinjavatest.service.impl;


import com.kolinjavatest.kolinjavatest.dto.OrderDto;
import com.kolinjavatest.kolinjavatest.exceptions.OrderNotFoundException;
import com.kolinjavatest.kolinjavatest.model.Order;
import com.kolinjavatest.kolinjavatest.repository.OrderRepository;
import com.kolinjavatest.kolinjavatest.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public void createOrder(OrderDto orderDto) {
        try {
            orderRepository.save(convertToEntity(orderDto));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateOrder(Long id, OrderDto orderDto) {
        Optional<Order> existedOrder = orderRepository.findOrderById(id);
        if (!existedOrder.isPresent())
            throw new OrderNotFoundException("Order not found");
        Order exOrder = existedOrder.get();

    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);

    }
    private Order convertToEntity(OrderDto orderDto) throws ParseException {

        return modelMapper.map(orderDto, Order.class);
    }
}
