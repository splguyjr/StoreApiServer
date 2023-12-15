package com.example.cloudproject.storeapi.controller;

import com.example.cloudproject.storeapi.dto.*;
import com.example.cloudproject.storeapi.entity.StoreStatic;
import com.example.cloudproject.storeapi.mapper.StoreMapper;
import com.example.cloudproject.storeapi.page.PageInfo;
import com.example.cloudproject.storeapi.service.StoreService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping({"store"})
public class StoreController {
    private final StoreService storeService;
    private final StoreMapper storeMapper;

    public StoreController(StoreService storeService, StoreMapper storeMapper) {
        this.storeService = storeService;
        this.storeMapper = storeMapper;
    }


    //searchword로 검색해 가게 정보 리스트 반환
    @GetMapping(path = "/search/text")
    public ResponseEntity getByText(@RequestBody StoreSearchTextRequestDTO storeSearchTextRequestDTO) {
        int page = storeSearchTextRequestDTO.getPage();
        int row = storeSearchTextRequestDTO.getRow();
        String searchWord = storeSearchTextRequestDTO.getSearchWord();

        Page<StoreStatic> storeStaticPage = storeService.paging(page-1, row, searchWord);
        PageInfo pageInfo = new PageInfo(page, row, storeStaticPage.getNumberOfElements(), (int)storeStaticPage.getTotalElements(), storeStaticPage.getTotalPages());

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

    //category로 검색해 가게 정보 리스트 반환
   @GetMapping(path = "/search/category")
   public ResponseEntity getByCategory(@RequestBody StoreSearchCategoryRequestDTO storeSearchCategoryRequestDTO) {
        int page = storeSearchCategoryRequestDTO.getPage();
        int row = storeSearchCategoryRequestDTO.getRow();
        Integer categoryId = storeSearchCategoryRequestDTO.getCategory();

       Page<StoreStatic> storeStaticPage = storeService.paging1(page-1, row, categoryId);
       PageInfo pageInfo = new PageInfo(page, row, storeStaticPage.getNumberOfElements(), (int)storeStaticPage.getTotalElements(), storeStaticPage.getTotalPages());

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

   //hashtag로 검색해 가게 정보 리스트 반환
    @GetMapping(path = "/search/hashtag")
    public ResponseEntity getByHashtag(@RequestBody StoreSearchHashtagRequestDTO storeSearchHashtagRequestDTO) {
        int page = storeSearchHashtagRequestDTO.getPage();
        int row = storeSearchHashtagRequestDTO.getRow();
        Integer hashtagId = storeSearchHashtagRequestDTO.getHashtagId();

        Page<StoreStatic> storeStaticPage = storeService.paging2(page-1, row, hashtagId);
        PageInfo pageInfo = new PageInfo(page, row, storeStaticPage.getNumberOfElements(), (int)storeStaticPage.getTotalElements(), storeStaticPage.getTotalPages());

        List<StoreStatic> sList = storeStaticPage.getContent();
        List<StoreSearchHashtagResponseDTO> response = new ArrayList<>();
        if(!sList.isEmpty()) {
            for(StoreStatic s : sList) {
                response.add(storeMapper.storeStaticToStoreSearchHashtagResponseDTO(s));
            }
            return new ResponseEntity<>(new StorePageDto<>(response, pageInfo), HttpStatus.OK);
        }

        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

   //storeId로 검색해 정보 반환
    @GetMapping(path = "/{storeId}")
    public ResponseEntity<StoreInfoResponseDTO> getByStoreId(@PathVariable Long storeId) {
        StoreStatic s = storeService.getStoreInfo(storeId);

        if (s == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        StoreInfoResponseDTO storeInfoResponseDTO = storeMapper.storeStaticToStoreInfoResponseDTO(s);

        return ResponseEntity.status(HttpStatus.OK).body(storeInfoResponseDTO);

    }

    @PatchMapping(path = "/{storeId}/hashtag-and-grade")
    public ResponseEntity updateHashtag(@PathVariable Long storeId, @RequestBody StoreHashtagUpdateRequestDTO storeHashtagUpdateRequestDTO) {

        Byte grade = storeHashtagUpdateRequestDTO.getGrade();
        List<Integer> hashtags = storeHashtagUpdateRequestDTO.getHashtags();

        if(storeService.updateHashtag(storeId, grade, hashtags)) {
           return ResponseEntity.ok().build();
       }

        else {
            return ResponseEntity.badRequest().build();
       }
    }

    //가게 id list를 받아 가게 이름 정보를 리스트로 돌려줌
    @GetMapping(path = "/name")
    public ResponseEntity getStoreList(@RequestParam List<Long> storeIdList) {

        List<StoreNameInfoListResponseDTO> response = new ArrayList<>();

        if(!storeIdList.isEmpty()) {
            for (Long storeId : storeIdList) {
                StoreStatic s = storeService.getStoreInfo(storeId);
                if (s != null) {
                    response.add(storeMapper.storeStaticToStoreNameInfoListResponseDTO(s));
                }
            }

            if (response.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            else {
                return new ResponseEntity<>(new StoreDto<>(response), HttpStatus.OK);
            }
        }

        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
