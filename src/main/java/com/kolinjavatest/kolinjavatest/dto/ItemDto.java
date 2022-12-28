package com.kolinjavatest.kolinjavatest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private String name;
    private Float unitPrice;
    private Integer quantity;
}
