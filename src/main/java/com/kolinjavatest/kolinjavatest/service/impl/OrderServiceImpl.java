package com.kolinjavatest.kolinjavatest.service.impl;


import com.kolinjavatest.kolinjavatest.dto.OrderDto;
import com.kolinjavatest.kolinjavatest.dto.OrderRequestDto;
import com.kolinjavatest.kolinjavatest.dto.OrderResponseDto;
import com.kolinjavatest.kolinjavatest.exceptions.OrderNotFoundException;
import com.kolinjavatest.kolinjavatest.model.Item;
import com.kolinjavatest.kolinjavatest.model.Order;
import com.kolinjavatest.kolinjavatest.repository.OrderRepository;
import com.kolinjavatest.kolinjavatest.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id.toString()));
        return order;
    }
    @Override
    public void createOrder(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setItems(orderRequestDto.getItems());
        List<Item> items = orderRequestDto.getItems();
        float total = 0f;
        for (Item i:items){
            total+=i.getQuantity()*i.getUnitPrice();
        }
        order.setTotal(total);
        orderRepository.save(order);

    }

    @Override
    public void updateOrder(Long id, OrderRequestDto orderRequestDto) {
        Optional<Order> existedOrder = orderRepository.findOrderById(id);
        if (!existedOrder.isPresent())
            throw new OrderNotFoundException("Order not found");
        Order order = new Order();
        order.setId(id);
        order.setItems(orderRequestDto.getItems());
        List<Item> items = orderRequestDto.getItems();
        float total = 0f;
        for (Item i:items){
            total+=i.getQuantity()*i.getUnitPrice();
        }
        order.setTotal(total);
        orderRepository.save(order);
       }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);

    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }


    private Order convertToEntity(OrderRequestDto orderRequestDto) throws ParseException {
        return modelMapper.map(orderRequestDto, Order.class);
    }
}
