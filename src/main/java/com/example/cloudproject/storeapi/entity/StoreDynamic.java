package com.example.cloudproject.storeapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class StoreDynamic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storeId;

    @Column(nullable = false)
    private String storeName;

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

    @Column(nullable = false)
    private Integer reviewNum;

}
