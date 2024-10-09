package com.example.testSecurity.controller;

import com.example.testSecurity.dto.ItemDto;
import com.example.testSecurity.mapper.ItemMapper;
import com.example.testSecurity.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @GetMapping(value = "/all-items")
    public List<ItemDto> allItems(){
        List<ItemDto> list = itemMapper.toListDto(itemService.allItems());
        for(ItemDto it: list){
           it.setModel("CRUTO");
        }

        return list;
    }

    @GetMapping(value = "/get-item/{id}")
    public ItemDto getItem(@PathVariable int id){
        return  itemMapper.toItemDto(itemService.getItemById(id));
    }

    @PostMapping(value = "/add-item")
    public void addItem(@RequestBody ItemDto itemDto){
        itemService.addItem(itemMapper.toItem(itemDto));
    }

    @PutMapping(value = "/update-item")
    public void updateItem(@RequestBody ItemDto itemDto){
        itemService.updateItem(itemMapper.toItem(itemDto));
    }

    @DeleteMapping(value = "/delete-item/{id}")
    public void deleteItem(@PathVariable int id){
        itemService.deleteItemById(id);
    }
}
