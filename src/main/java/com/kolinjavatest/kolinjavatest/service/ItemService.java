package com.kolinjavatest.kolinjavatest.service;

import com.kolinjavatest.kolinjavatest.dto.ItemDto;

import java.util.List;

public interface ItemService {


    void createItem(ItemDto itemDto);
    void updateItem(Long id, ItemDto itemDto);
    void deleteItem(ItemDto itemDto);

    public List<ItemDto> getItemsByOrderId(Long orderId);
}

