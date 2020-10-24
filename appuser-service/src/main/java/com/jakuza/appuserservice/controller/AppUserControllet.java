package com.jakuza.appuserservice.controller;

import java.util.List;
import java.util.UUID;

import com.jakuza.appuserservice.model.dto.AppUserDto;
import com.jakuza.appuserservice.service.AppUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class AppUserControllet {

    @Autowired
    private AppUserService userService;

    @GetMapping
    public ResponseEntity<List<AppUserDto>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserDto> findUser(@PathVariable UUID id){
        return ResponseEntity.ok().body(userService.findUser(id));    
    }
}