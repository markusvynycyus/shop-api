package com.venicios.shop_api.api.assembler;

import com.venicios.shop_api.domain.dto.input.ShopInput;
import com.venicios.shop_api.domain.model.Shop;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShopInputDisassembler {

    @Autowired
    private ModelMapper modelMaper;

    @Autowired
    private ModelMapper modelMapper;

    public Shop toDomainObject(ShopInput shopInput) {

        return modelMapper.map(shopInput, Shop.class);
    }

    public void copyToDomainObject(ShopInput shopInput, Shop shop) {
        modelMapper.map(shopInput, shop);
    }
}
