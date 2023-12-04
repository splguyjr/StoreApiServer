package com.example.cloudproject.storeapi.service;

import com.example.cloudproject.storeapi.dto.StoreSearchTextResponseDTO;
import com.example.cloudproject.storeapi.entity.StoreStatic;
import com.example.cloudproject.storeapi.repository.StoreStaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final StoreStaticRepository storeStaticRepository;

    @Autowired
    public UserService(StoreStaticRepository storeStaticRepository) {
        this.storeStaticRepository = storeStaticRepository;
    }

    public Page<StoreStatic> paging(int page, int row, String searchWord) {
        PageRequest pageRequest = PageRequest.of(page, row);
        return storeStaticRepository.findByStoreNameLike("%" +searchWord+ "%", pageRequest);
    }

    public Page<StoreStatic> paging1(int page, int row, Integer categoryId) {
        PageRequest pageRequest = PageRequest.of(page, row);
        return storeStaticRepository.findByCategoryId_CategoryId(categoryId, pageRequest);
    }

    //Read by searchWord
    /*public StoreSearchTextResponseDTO getText(String searchWord) {
        List<StoreStatic> sList = this.storeStaticRepository.findByStoreNameLike("%"+searchWord+"%");
        //여러 개 처리 어떻게 할지 생각하기

        if (sList.isEmpty()) {
            return null;
        }

        StoreSearchTextResponseDTO storeSearchTextResponseDTO = new StoreSearchTextResponseDTO();
        storeSearchTextResponseDTO.setStoreId(sList.get(0).getStoreId());
        storeSearchTextResponseDTO.setStoreName(sList.get(0).getStoreName());
        storeSearchTextResponseDTO.setGrade((byte)10);
        List<Integer> l = new ArrayList<>(3);
        l.add(1);
        l.add(2);
        l.add(3);
        storeSearchTextResponseDTO.setHashtags(l);

        return storeSearchTextResponseDTO;
    }*/
}
