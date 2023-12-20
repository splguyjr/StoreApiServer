package com.example.cloudproject.storeapi.dto;

import lombok.*;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreSearchHashtagResponseDTO {
    private String storeName;

    private Byte grade;

    private Long storeId;

    private Integer category;

    private List<Integer> hashtags;
}
