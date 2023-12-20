package com.example.cloudproject.storeapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Category {
    @Id
    private Integer categoryId;

    @Column(nullable = false)
    private String CategoryName;
}
