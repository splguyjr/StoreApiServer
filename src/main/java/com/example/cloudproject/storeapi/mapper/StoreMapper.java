package com.example.cloudproject.storeapi.mapper;

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
        Byte grade = (byte)(storeStatic.getGradeSum()/ storeStatic.getGradeNum() * 10);//소수점 첫째 자리까지 표현하기 위해 *10, 50이면 5.0을 의미
        List<Integer> hashtags = new ArrayList<Integer>();
        hashtags.add(storeStatic.getHashtagId1());
        hashtags.add(storeStatic.getHashtagId2());
        hashtags.add(storeStatic.getHashtagId3());

        return StoreSearchTextResponseDTO.builder()
                .storeId(storeStatic.getStoreId())
                .storeName(storeStatic.getStoreName())
                .grade(grade).hashtags(hashtags)
                .build();
    }
}
