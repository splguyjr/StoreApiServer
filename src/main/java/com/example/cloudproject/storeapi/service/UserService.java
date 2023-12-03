package com.example.cloudproject.storeapi.service;

import com.example.cloudproject.storeapi.dto.StoreSearchTextResponseDTO;
import com.example.cloudproject.storeapi.entity.StoreStatic;
import com.example.cloudproject.storeapi.repository.StoreDynamicRepository;
import com.example.cloudproject.storeapi.repository.StoreStaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final StoreStaticRepository storeStaticRepository;
    private final StoreDynamicRepository storeDynamicRepository;

    @Autowired
    public UserService(StoreStaticRepository storeStaticRepository, StoreDynamicRepository storeDynamicRepository) {
        this.storeStaticRepository = storeStaticRepository;
        this.storeDynamicRepository = storeDynamicRepository;
    }

    //Read by searchWord
    public StoreSearchTextResponseDTO getText(String searchWord) {
        List<StoreStatic> sList = this.storeStaticRepository.findByStoreNameLike("%"+searchWord+"%");

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
    }

}
