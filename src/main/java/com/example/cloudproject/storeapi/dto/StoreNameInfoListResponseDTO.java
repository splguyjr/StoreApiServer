package com.example.cloudproject.storeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreNameInfoListResponseDTO {
    private Long storeId;
    private String storeName;
}
