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
import org.springframework.web.bind.annotation.*;

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


    //searchword로 검색해 반환
    @GetMapping(path = "/search/text")
    public ResponseEntity getByText(@RequestBody StoreSearchTextRequestDTO storeSearchTextRequestDTO) {
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

    //category로 검색해 반환
   @GetMapping(path = "/search/category")
   public ResponseEntity getByCategory(@RequestBody StoreSearchCategoryRequestDTO storeSearchCategoryRequestDTO) {
        int page = storeSearchCategoryRequestDTO.getPage();
        int size = storeSearchCategoryRequestDTO.getRow();
        Integer categoryId = storeSearchCategoryRequestDTO.getCategory();

       Page<StoreStatic> storeStaticPage = userService.paging1(page-1, size, categoryId);
       PageInfo pageInfo = new PageInfo(page, size, (int)storeStaticPage.getTotalElements(), storeStaticPage.getTotalPages());

       List<StoreStatic> sList = storeStaticPage.getContent();
       List<StoreSearchCategoryResponseDTO> response = new ArrayList<>();
       if(!sList.isEmpty()) {
           for(StoreStatic s : sList) {
               response.add(storeMapper.storeStaticToStoreSearchCategoryResponseDTO(s));
           }
           return new ResponseEntity<>(new StorePageDto<>(response, pageInfo), HttpStatus.OK);
       }

       else {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
   }

    @GetMapping(path = "/{storeId}")
    public ResponseEntity<StoreInfoResponseDTO> getByStoreId(@PathVariable Long storeId) {
        StoreStatic s = userService.getStoreInfo(storeId);
        StoreInfoResponseDTO storeInfoResponseDTO = storeMapper.storeStaticToStoreInfoResponseDTO(s);

        if (storeInfoResponseDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        else {
            return ResponseEntity.status(HttpStatus.OK).body(storeInfoResponseDTO);
        }
    }


}
