package com.venicios.shop_api.domain.service;

import com.venicios.shop_api.domain.model.Shop;
import com.venicios.shop_api.domain.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopService {

    @Autowired
    private ShopRepository shopRepository;

    public Shop salvar (Shop shop){
        return shopRepository.save(shop);
    }
}
