package com.example.testSecurity.dto;


import com.example.testSecurity.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ItemDto {

    private int id;

    private LocalDateTime sozdal;

    private LocalDateTime obnovil;

    private String name;

    private String description;

    private double price;

    private String model;

    private String email;


}
