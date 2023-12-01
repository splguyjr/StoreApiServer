package com.example.cloudproject.storeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class StoreSearchCategoryResponseDTO {
    private String storeName;
    private Byte grade;
    private Long storeId;
    private List<Integer> hashtags;

}
