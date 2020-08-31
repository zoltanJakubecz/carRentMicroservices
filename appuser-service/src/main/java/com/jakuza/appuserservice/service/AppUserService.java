package com.jakuza.appuserservice.service;

import java.util.List;
import java.util.stream.*;

import com.jakuza.appuserservice.model.dto.AppUserDto;
import com.jakuza.appuserservice.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

    @Autowired
    AppUserRepository userRepository;

	public List<AppUserDto> getUsers() {
		return userRepository.findAll().stream().map(AppUserDto::fromEntity).collect(Collectors.toList());
	}

    
}