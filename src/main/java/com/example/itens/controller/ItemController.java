package com.example.itens.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.itens.model.Item;
import com.example.itens.service.ItemService;

@RestController
@RequestMapping("item/v1")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems(){
       return itemService.getAllItems(); 
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id){
        return itemService.getItemById(id);
    }


    @PostMapping
    public void saveItem(@RequestBody Item request){
        itemService.createItem(request);
    }

    @PutMapping("/{id}")
    public void updateItem(@PathVariable Long id,@RequestBody Item requestUpdate){
        itemService.updateItemById(id,requestUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable Long id){
        itemService.deleteItemById(id);
    }
}
