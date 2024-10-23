package com.venicios.shop_api.api.controller;

import com.venicios.shop_api.api.assembler.ShopInputDisassembler;
import com.venicios.shop_api.api.assembler.ShopModelAssembler;
import com.venicios.shop_api.domain.dto.ShopDTO;
import com.venicios.shop_api.domain.dto.input.ShopInput;
import com.venicios.shop_api.domain.model.Shop;
import com.venicios.shop_api.domain.repository.ShopRepository;
import com.venicios.shop_api.domain.service.ShopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value= "/shop")
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    @Autowired
    private ShopModelAssembler shopModelAssembler;

    @Autowired
    private ShopInputDisassembler shopInputDisassembler;

    @Autowired
    private ShopService shopService;


    @GetMapping
    public List<ShopDTO> listar() {
        List<Shop> shops = shopRepository.findAll();
        return shopModelAssembler.toCollectionModel(shops);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShopDTO adicionar(@RequestBody @Valid ShopInput shopInput) {
        Shop shop = shopInputDisassembler.toDomainObject(shopInput);
        shop = shopService.salvar(shop);
        return shopModelAssembler.toModel(shop);
    }

}
