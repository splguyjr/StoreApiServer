package com.example.cloudproject.storeapi.service;

import com.example.cloudproject.storeapi.entity.StoreStatic;
import com.example.cloudproject.storeapi.repository.StoreStaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreService {

    private final StoreStaticRepository storeStaticRepository;

    @Autowired
    public StoreService(StoreStaticRepository storeStaticRepository) {
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

    public Page<StoreStatic> paging2(int page, int row, Integer hashtagId) {
        PageRequest pageRequest = PageRequest.of(page, row);
        return storeStaticRepository.findByHashtagId1OrHashtagId2OrHashtagId3(hashtagId, hashtagId,hashtagId, pageRequest);
    }

    public StoreStatic getStoreInfo(Long storeId) {
        Optional<StoreStatic> store = storeStaticRepository.findById(storeId);
        if (store.isPresent()) {
            return store.get();
        }
        else {
            return null;
        }
    }

    public boolean updateHashtag(Long storeId, Byte grade, List<Integer> hashtags) {
        Optional<StoreStatic> store = storeStaticRepository.findById(storeId);
        if (store.isPresent()) {
            Integer hashtag1 = hashtags.get(0);
            Integer hashtag2 = hashtags.get(1);
            Integer hashtag3 = hashtags.get(2);

            StoreStatic updateHashtag = store.get();
            updateHashtag.setGrade(grade);
            updateHashtag.setHashtagId1(hashtag1);
            updateHashtag.setHashtagId2(hashtag2);
            updateHashtag.setHashtagId3(hashtag3);
            storeStaticRepository.save(updateHashtag);

            return true;
        }
        else {
            return false;
        }
    }

}
