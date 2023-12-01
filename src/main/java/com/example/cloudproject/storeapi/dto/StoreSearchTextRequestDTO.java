package com.example.cloudproject.storeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class StoreSearchTextRequestDTO {
    private String searchWord;
    private Integer row;
    private Integer page;
}
