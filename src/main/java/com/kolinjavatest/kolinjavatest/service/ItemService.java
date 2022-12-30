package com.kolinjavatest.kolinjavatest.service;

import com.kolinjavatest.kolinjavatest.dto.ItemDto;
import com.kolinjavatest.kolinjavatest.model.Item;
import com.kolinjavatest.kolinjavatest.model.Order;

import java.util.List;

public interface ItemService {


    //void createItem(ItemDto itemDto);
    //void updateItem(Long id, ItemDto itemDto);
    //void deleteItem(ItemDto itemDto);

    List<ItemDto> getItemsByOrderId(Long orderId);
    void item(ItemDto itemDto); //Creates item to order
    Item mapToItem(ItemDto itemDto, Order order);
}

