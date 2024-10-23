package com.venicios.shop_api.api.controller;

import com.venicios.shop_api.api.assembler.ShopInputDisassembler;
import com.venicios.shop_api.api.assembler.ShopModelAssembler;
import com.venicios.shop_api.domain.dto.ShopDTO;
import com.venicios.shop_api.domain.dto.input.ShopInput;
import com.venicios.shop_api.domain.model.Shop;
import com.venicios.shop_api.domain.model.ShopItem;
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
//        shop = shopService.salvar(shop); // Salve o Shop primeiro

        // Agora, associe os itens da compra ao Shop
        for (ShopItem shopItem : shop.getItems()) {
            shopItem.setShop(shop); // Associe o Shop aos ShopItems
        }

        // Salve novamente para garantir que os ShopItems sejam persistidos
        shop = shopService.salvar(shop); // Salve novamente o Shop com os itens associados

        return shopModelAssembler.toModel(shop);
    }

}
