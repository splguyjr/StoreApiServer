package com.example.cloudproject.storeapi.controller;

import com.example.cloudproject.storeapi.dto.StoreSearchTextRequestDTO;
import com.example.cloudproject.storeapi.dto.StoreSearchTextResponseDTO;
import com.example.cloudproject.storeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"store"})
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //searchword, row, page를 받아
    @GetMapping(path = "/search/text")
    public ResponseEntity<StoreSearchTextResponseDTO> getText(@RequestBody StoreSearchTextRequestDTO storeSearchTextRequestDTO) {
        StoreSearchTextResponseDTO storeSearchTextResponseDTO = userService.getText(storeSearchTextRequestDTO.getSearchWord());

        if (storeSearchTextResponseDTO == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        else {
            return new ResponseEntity<>(storeSearchTextResponseDTO, HttpStatus.OK);
        }
    }


}
