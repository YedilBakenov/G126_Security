package com.example.testSecurity.service;

import com.example.testSecurity.dto.ItemDto;
import com.example.testSecurity.model.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    void addItem(Item item);

    Item getItemById(int id);

    List<Item> allItems();

    void updateItem(Item item);

    void deleteItemById(int id);


}
