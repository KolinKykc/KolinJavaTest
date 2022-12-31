package com.kolinjavatest.kolinjavatest.service;

import com.kolinjavatest.kolinjavatest.dto.ItemDto;
import com.kolinjavatest.kolinjavatest.model.Item;
import com.kolinjavatest.kolinjavatest.model.Order;

import java.util.List;

public interface ItemService {

    List<ItemDto> getItemsByOrderId(Long orderId);
    void item(ItemDto itemDto);
    Item mapToItem(ItemDto itemDto, Order order);
}

