package com.example.cloudproject.storeapi.dto;

import com.example.cloudproject.storeapi.page.PageInfo;
import lombok.Getter;

@Getter
public class StorePageDto<T> {
    private T stores;
    private PageInfo pageInfo;

    public StorePageDto(T stores, PageInfo pageInfo) {
        this.stores = stores;
        this.pageInfo = pageInfo;
    }
}
