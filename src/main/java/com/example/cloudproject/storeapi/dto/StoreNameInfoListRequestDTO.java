package com.example.cloudproject.storeapi.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StoreNameInfoListRequestDTO {
    private List<Long> storeIds;
}
