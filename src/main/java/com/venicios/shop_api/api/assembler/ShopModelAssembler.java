package com.venicios.shop_api.api.assembler;

import com.venicios.shop_api.domain.dto.ShopDTO;
import com.venicios.shop_api.domain.model.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShopModelAssembler {

    @Autowired
    private ModelMapper modelMaper;

    public ShopDTO toModel(Shop shop) {
        return modelMaper.map(shop, ShopDTO.class);
    }

    public List<ShopDTO> toCollectionModel(List<Shop> shops) {
        return shops.stream()
                .map(shop -> toModel(shop))
                .collect(Collectors.toList());
    }

}
