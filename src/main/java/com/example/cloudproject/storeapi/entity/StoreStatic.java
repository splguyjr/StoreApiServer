package com.example.cloudproject.storeapi.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class StoreStatic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(nullable = false)
    private String storeName;

    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private Category categoryId;

    @Column(nullable = false)
    private double x;

    @Column(nullable = false)
    private double y;

    @Column(nullable = false)
    private Boolean isOpen;

    @Column
    private Integer hashtagId1;

    @Column
    private Integer hashtagId2;

    @Column
    private Integer hashtagId3;

    @Column(nullable = false)
    private double gradeSum;

    @Column(nullable = false)
    private Integer gradeNum;

    @Column(nullable = false)
    private Integer preferenceNum;
}
