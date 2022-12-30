package com.kolinjavatest.kolinjavatest.dto;

import com.kolinjavatest.kolinjavatest.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDto {
    private List<Item> items;

}
