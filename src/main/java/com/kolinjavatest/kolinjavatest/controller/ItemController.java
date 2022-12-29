package com.kolinjavatest.kolinjavatest.controller;

import com.kolinjavatest.kolinjavatest.dto.ItemDto;
import com.kolinjavatest.kolinjavatest.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.http.ResponseEntity.status;

import java.util.List;

@RestController
@RequestMapping("/items")
@AllArgsConstructor
public class ItemController {
    @Autowired
    ItemService itemService;

    @GetMapping("/items-by-order/{id}")
    @ResponseBody
    public ResponseEntity<List<ItemDto>> findAllItemsByProductId(@PathVariable long id) {
        List<ItemDto> items = itemService.getItemsByOrderId(id);
        return status(HttpStatus.OK).body(items);
    }


}
