package com.kolinjavatest.kolinjavatest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Items")
public class Item {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long itemId;
    private String name;
    private Float unitPrice;
    private Integer quantity;

    @ManyToOne(fetch = LAZY)
    @JsonIgnore
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Order order;
}
