package com.example.cloudproject.storeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StoreSearchHashtagRequestDTO {
    private Integer HashtagId;
    private Integer row;
    private Integer page;
}
