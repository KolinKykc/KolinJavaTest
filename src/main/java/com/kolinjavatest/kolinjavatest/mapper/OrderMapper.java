package com.kolinjavatest.kolinjavatest.mapper;
import com.kolinjavatest.kolinjavatest.dto.OrderDto;
import com.kolinjavatest.kolinjavatest.model.Order;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public interface OrderMapper {
    /*
    @Autowired
    ModelMapper modelMapper;

    private OrderDto convertToDto(Optional<Order> order) {
        return modelMapper.map(order.get(), OrderDto.class);
    }

    private Order convertDtoToClass(Optional<OrderDto> orderDto) {
        return modelMapper.map(orderDto.get(), Order.class);
    }

     */
}
