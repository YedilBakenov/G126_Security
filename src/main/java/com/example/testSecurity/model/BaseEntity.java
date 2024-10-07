package com.example.testSecurity.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updateAt = LocalDateTime.now();
    }
}
