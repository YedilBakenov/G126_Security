package com.example.testSecurity.service.impl;

import com.example.testSecurity.model.Item;
import com.example.testSecurity.repository.ItemRepository;
import com.example.testSecurity.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void addItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public Item getItemById(int id) {
        return itemRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Item> allItems() {
        return itemRepository.findAll();
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void deleteItemById(int id) {
        itemRepository.deleteById(id);
    }
}
