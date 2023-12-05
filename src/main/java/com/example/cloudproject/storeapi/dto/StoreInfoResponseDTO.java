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
public class StoreInfoResponseDTO {
    private String storeName;
    private Byte grade;
    private Double x;
    private Double y;
    private List<Integer> hashtags;
}
