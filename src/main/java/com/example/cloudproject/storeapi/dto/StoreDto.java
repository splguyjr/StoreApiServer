package com.example.cloudproject.storeapi.dto;

import lombok.Getter;

@Getter
public class StoreDto<T> {
    private T result;

    public StoreDto(T result) {
        this.result = result;
    }
}

