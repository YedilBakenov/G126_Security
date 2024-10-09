package com.example.testSecurity.mapper;


import com.example.testSecurity.dto.ItemDto;
import com.example.testSecurity.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    @Mapping(source = "createdAt", target = "sozdal")
    @Mapping(source = "updateAt", target = "obnovil")
    ItemDto toItemDto(Item item);


    @Mapping(source = "sozdal", target = "createdAt")
    @Mapping(source = "obnovil", target = "updateAt")
    Item toItem(ItemDto itemDto);

    List<ItemDto> toListDto(List<Item> items);

    List<Item> toList(List<ItemDto> itemsDtos);

}
