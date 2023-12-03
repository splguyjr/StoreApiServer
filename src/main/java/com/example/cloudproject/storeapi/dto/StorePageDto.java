package com.example.cloudproject.storeapi.dto;

import com.example.cloudproject.storeapi.page.PageInfo;
import lombok.Getter;

@Getter
public class StorePageDto<T> {
    private T data;
    private PageInfo pageInfo;

    public StorePageDto(T data, PageInfo pageInfo) {
        this.data = data;
        this.pageInfo = pageInfo;
    }
}
