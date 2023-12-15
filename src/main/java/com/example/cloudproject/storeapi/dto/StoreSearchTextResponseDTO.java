package com.example.cloudproject.storeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreSearchTextResponseDTO {
    private String storeName;

    private Byte grade;

    private Long storeId;

    private Integer category;

    private List<Integer> hashtags;
}
