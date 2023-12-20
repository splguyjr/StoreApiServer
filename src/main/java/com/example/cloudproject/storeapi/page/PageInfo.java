package com.example.cloudproject.storeapi.page;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PageInfo {
    private int page;
    private int row;
    private int elements;
    private int totalElements;
    private int totalPages;
}
