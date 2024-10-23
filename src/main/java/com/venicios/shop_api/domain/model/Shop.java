package com.venicios.shop_api.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Shop {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identifier;

    private String status;

    @Column(name = "date_shop")
    private LocalDate dateShop;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "shop")
    private List<ShopItem> items;
}
