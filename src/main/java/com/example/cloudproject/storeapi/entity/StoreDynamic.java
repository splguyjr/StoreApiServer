package com.example.cloudproject.storeapi.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class StoreDynamic {
    @Id
    @Column(name = "storeId", nullable = false)
    private Long storeId;

    @OneToOne
    @MapsId//@MapsId 는 @id로 지정한 컬럼에 @OneToOne 이나 @ManyToOne 관계를 매핑시키는 역할
    @JoinColumn(name = "storeId")
    private StoreStatic storeStatic;

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
