package com.kolinjavatest.kolinjavatest.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String name;
    private Float unitPrice;
    private Integer quantity;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Order order;
}
