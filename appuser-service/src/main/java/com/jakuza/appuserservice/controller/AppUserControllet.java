package com.jakuza.appuserservice.controller;

import java.util.List;
import java.util.UUID;

import com.jakuza.appuserservice.model.dto.AppUserDto;
import com.jakuza.appuserservice.model.dto.AppUserRegisterDto;
import com.jakuza.appuserservice.service.AppUserService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequiredArgsConstructor
public class AppUserControllet {

    private final AppUserService userService;


    @GetMapping("/")
    public ResponseEntity<List<AppUserDto>> getUsers(){
        return ResponseEntity.ok().body(userService.getUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppUserDto> findUser(@PathVariable UUID id){
        return ResponseEntity.ok().body(userService.findUser(id));    
    }

    @PostMapping("/")
    public ResponseEntity<AppUserDto> addUser(@RequestBody AppUserRegisterDto userToAdd){
        return ResponseEntity.ok().body(userService.addUser(userToAdd));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AppUserDto> updateUser(@PathVariable UUID id, @RequestBody AppUserDto user){
        return ResponseEntity.ok().body(userService.updateUser(id, user));
    }
}