package com.example.testSecurity.service.impl;

import com.example.testSecurity.dto.ItemDto;
import com.example.testSecurity.model.Item;
import com.example.testSecurity.model.User;
import com.example.testSecurity.repository.ItemRepository;
import com.example.testSecurity.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final UserServiceImpl userService;

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

    public ItemDto toItemDto(Item item) {
        if ( item == null ) {
            return null;
        }

        User user =  userService.getCurrentUser();

        ItemDto itemDto = new ItemDto();

        itemDto.setSozdal( item.getCreatedAt() );
        itemDto.setObnovil( item.getUpdateAt() );
        itemDto.setId( item.getId() );
        itemDto.setName( item.getName() );
        itemDto.setDescription( item.getDescription() );
        itemDto.setPrice( item.getPrice() );
        itemDto.setEmail(user.getEmail());
        return itemDto;
    }

}
