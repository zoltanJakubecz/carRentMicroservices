package com.jakuza.appuserservice.controller;

import java.util.List;

import com.jakuza.appuserservice.model.dto.AppUserDto;
import com.jakuza.appuserservice.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AppUserControllet {
    
    @Autowired
    private AppUserService userService;

    public ResponseEntity<List<AppUserDto>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }
}