package com.venicios.shop_api.domain.service;

import com.venicios.shop_api.domain.model.Shop;
import com.venicios.shop_api.domain.model.ShopItem;
import com.venicios.shop_api.domain.repository.ShopItemRepository;
import com.venicios.shop_api.domain.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopItemService {

    @Autowired
    private ShopItemRepository shopItemRepository;

    public ShopItem salvar (ShopItem ShopItem){
        return shopItemRepository.save(ShopItem);
    }
}
