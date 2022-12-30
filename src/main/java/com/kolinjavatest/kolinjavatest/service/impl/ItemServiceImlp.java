package com.kolinjavatest.kolinjavatest.service.impl;

import com.kolinjavatest.kolinjavatest.dto.ItemDto;
import com.kolinjavatest.kolinjavatest.exceptions.OrderNotFoundException;
import com.kolinjavatest.kolinjavatest.model.Item;
import com.kolinjavatest.kolinjavatest.model.Order;
import com.kolinjavatest.kolinjavatest.repository.ItemRepository;
import com.kolinjavatest.kolinjavatest.repository.OrderRepository;
import com.kolinjavatest.kolinjavatest.service.ItemService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImlp implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ModelMapper modelMapper;
    @Autowired
    OrderRepository orderRepository;

    @Transactional
    public List<ItemDto> getItemsByOrderId(Long orderId) {
        Optional<Order> order = orderRepository.findOrderById(orderId);
                //.orElseThrow(() -> new SubredditNotFoundException(subredditId.toString()));
        List<ItemDto> items = convertToDtoList(itemRepository.findAllByOrder(order));
        return items;
    }


    @Override
    public Item mapToItem(ItemDto itemDto, Order order) {
        return Item.builder()
                .name(itemDto.getName())
                .unitPrice(itemDto.getUnitPrice())
                .quantity(itemDto.getQuantity())
                .order(order)
                .build();
    }


    //TODO remove or not?
    @Transactional
    public void item(ItemDto itemDto) {
        Order order = orderRepository.findById(itemDto.getOrderId())
                .orElseThrow(() -> new OrderNotFoundException("Post Not Found with ID - " + itemDto.getOrderId()));
        List<Item> items = itemRepository.findAllByOrder(Optional.ofNullable(order));
        items.add(mapToItem(itemDto, order));
        order.setItems(items);
        float total = 0;
        for(Item item: items){
           int quantity = item.getQuantity();
           float unitePrice = item.getUnitPrice();
           total+= quantity*unitePrice;
        }
        order.setTotal(total);
        itemRepository.save(mapToItem(itemDto, order));
        orderRepository.save(order);
    }

    private List<ItemDto> convertToDtoList(List<Item> item) {
        // Create Conversion Type
        Type listType = new TypeToken<List<ItemDto>>() {
        }.getType();
        // Convert List of Entity objects to a List of DTOs objects
        List<ItemDto> returnValue = new ModelMapper().map(item, listType);
        return returnValue;
    }

}

/*    @Override
    public void createItem(ItemDto itemDto) {
        try {
            itemRepository.save(convertToEntity(itemDto));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }   //Convert dto to entity

    private Item convertToEntity(ItemDto itemDto) throws ParseException {

        return modelMapper.map(itemDto, Item.class);
    }
    // CONVERTING entity to dto

    private ItemDto convertToDto(Optional<Item> item) {
        return modelMapper.map(item.get(), ItemDto.class);
    }
*/