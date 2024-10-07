package com.example.testSecurity.controller;

import com.example.testSecurity.model.Item;
import com.example.testSecurity.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;


    @GetMapping(value = "/all-items")
    public List<Item> allItems(){
        return itemService.allItems();
    }

    @GetMapping(value = "/get-item/{id}")
    public Item getItem(@PathVariable int id){
        return itemService.getItemById(id);
    }

    @PostMapping(value = "/add-item")
    public void addItem(@RequestBody Item item){
        itemService.addItem(item);
    }

    @PutMapping(value = "/update-item")
    public void updateItem(@RequestBody Item item){
        itemService.updateItem(item);
    }

    @DeleteMapping(value = "/delete-item/{id}")
    public void deleteItem(@PathVariable int id){
        itemService.deleteItemById(id);
    }
}
