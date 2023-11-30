package com.example.cloudproject.storeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StoreSearchCategoryRequestDTO {
    private Integer category;
    private Integer row;
    private Integer page;
}
