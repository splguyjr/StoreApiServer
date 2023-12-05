package com.example.cloudproject.storeapi.mapper;


import com.example.cloudproject.storeapi.dto.StoreInfoResponseDTO;
import com.example.cloudproject.storeapi.dto.StoreSearchCategoryResponseDTO;
import com.example.cloudproject.storeapi.dto.StoreSearchHashtagResponseDTO;
import com.example.cloudproject.storeapi.dto.StoreSearchTextResponseDTO;
import com.example.cloudproject.storeapi.entity.StoreStatic;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Component;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@Component
public class StoreMapper {

    // private String storeName;
    //    private Byte grade;
    //    private Long storeId;
    //    private List<Integer> hashtags;
    public StoreSearchTextResponseDTO storeStaticToStoreSearchTextResponseDTO(StoreStatic storeStatic) {
        Byte grade = storeStatic.getGrade();
        List<Integer> hashtags = new ArrayList<>();
        hashtags.add(storeStatic.getHashtagId1());
        hashtags.add(storeStatic.getHashtagId2());
        hashtags.add(storeStatic.getHashtagId3());

        return StoreSearchTextResponseDTO.builder()
                .storeId(storeStatic.getStoreId())
                .storeName(storeStatic.getStoreName())
                .grade(grade)
                .hashtags(hashtags)
                .build();
    }

    public StoreSearchCategoryResponseDTO storeStaticToStoreSearchCategoryResponseDTO(StoreStatic storeStatic) {
        Byte grade = storeStatic.getGrade();
        List<Integer> hashtags = new ArrayList<>();
        hashtags.add(storeStatic.getHashtagId1());
        hashtags.add(storeStatic.getHashtagId2());
        hashtags.add(storeStatic.getHashtagId3());

        return StoreSearchCategoryResponseDTO.builder()
                .storeId(storeStatic.getStoreId())
                .storeName(storeStatic.getStoreName())
                .grade(grade)
                .hashtags(hashtags)
                .build();
    }

    public StoreSearchHashtagResponseDTO storeStaticToStoreSearchHashtagResponseDTO(StoreStatic storeStatic) {
        Byte grade = storeStatic.getGrade();
        List<Integer> hashtags = new ArrayList<>();
        hashtags.add(storeStatic.getHashtagId1());
        hashtags.add(storeStatic.getHashtagId2());
        hashtags.add(storeStatic.getHashtagId3());

        return StoreSearchHashtagResponseDTO.builder()
                .storeName(storeStatic.getStoreName())
                .storeId(storeStatic.getStoreId())
                .grade(grade)
                .hashtags(hashtags)
                .build();
    }

    public StoreInfoResponseDTO storeStaticToStoreInfoResponseDTO(StoreStatic storeStatic) {
        Byte grade = storeStatic.getGrade();
        List<Integer> hashtags = new ArrayList<>();
        hashtags.add(storeStatic.getHashtagId1());
        hashtags.add(storeStatic.getHashtagId2());
        hashtags.add(storeStatic.getHashtagId3());

        return StoreInfoResponseDTO.builder()
                .storeName(storeStatic.getStoreName())
                .x(storeStatic.getX())
                .y(storeStatic.getY())
                .grade(grade)
                .hashtags(hashtags)
                .build();
    }


}
