package com.example.cloudproject.storeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class StoreInfoResponseDTO {
    private String storeName;
    private Byte grade;
    private Double x;
    private Double y;
    private List<Integer> hastags;
}
