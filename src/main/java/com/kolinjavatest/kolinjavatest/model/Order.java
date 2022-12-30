package com.kolinjavatest.kolinjavatest.model;

import com.kolinjavatest.kolinjavatest.dto.ItemDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float total;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Item> items;


}
