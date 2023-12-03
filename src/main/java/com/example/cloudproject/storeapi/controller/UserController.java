package com.example.cloudproject.storeapi.controller;

import com.example.cloudproject.storeapi.dto.*;
import com.example.cloudproject.storeapi.entity.StoreStatic;
import com.example.cloudproject.storeapi.mapper.StoreMapper;
import com.example.cloudproject.storeapi.page.PageInfo;
import com.example.cloudproject.storeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"store"})
public class UserController {
    private final UserService userService;
    private final StoreMapper storeMapper;

    public UserController(UserService userService, StoreMapper storeMapper) {
        this.userService = userService;
        this.storeMapper = storeMapper;
    }


    //searchword, row, page를 받아
    @GetMapping(path = "/search/text")
    public ResponseEntity getText(@RequestBody StoreSearchTextRequestDTO storeSearchTextRequestDTO) {
        int page = storeSearchTextRequestDTO.getPage();
        int size = storeSearchTextRequestDTO.getRow();
        String searchWord = storeSearchTextRequestDTO.getSearchWord();

        Page<StoreStatic> storeStaticPage = userService.paging(page-1, size, searchWord);
        PageInfo pageInfo = new PageInfo(page, size, (int)storeStaticPage.getTotalElements(), storeStaticPage.getTotalPages());

        List<StoreStatic> sList = storeStaticPage.getContent();
        List<StoreSearchTextResponseDTO> response = new ArrayList<>();
        if(!sList.isEmpty()) {
            for(StoreStatic s : sList) {
                response.add(storeMapper.storeStaticToStoreSearchTextResponseDTO(s));
            }
            return new ResponseEntity<>(new StorePageDto<>(response, pageInfo), HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

   /* @GetMapping(path = "/search/category")
    public ResponseEntity<StoreSearchTextResponseDTO> getCategory(@RequestBody StoreSearchCategoryRequestDTO storeSearchCategoryRequestDTO) {
        StoreSearchCategoryResponseDTO storeSearchCategoryResponseDTO = userService.get(storeSearchCategoryRequestDTO.getCategory());

        if (storeSearchCategoryResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        else {
            return new ResponseEntity<>(storeSearchCategoryResponseDTO, HttpStatus.OK);
        }
    }*/


}
