package com.stw.bountyhunters.controllers;

import com.stw.bountyhunters.model.EquippedItem;
import com.stw.bountyhunters.services.EquippedItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class ItemController {

    private final EquippedItemService equippedItemService;

    public ItemController(EquippedItemService equippedItemService) {
        this.equippedItemService = equippedItemService;
    }

    @RequestMapping({"/items", "/items/index", "/items/index.html"})
    public String getItems(Model model) {
        Set<EquippedItem> items = equippedItemService.findAll();

        model.addAttribute("itemsList", items);

        return "items/index";
    }
}
