package com.jakuza.appuserservice.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.*;

import com.jakuza.appuserservice.model.AppUser;
import com.jakuza.appuserservice.model.dto.AppUserDto;
import com.jakuza.appuserservice.model.dto.AppUserRegisterDto;
import com.jakuza.appuserservice.repository.AppUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {

	@Autowired
	private PasswordEncoder encoder;

    @Autowired
    private AppUserRepository userRepository;

	public List<AppUserDto> getUsers() {
		return userRepository.findAll().stream().map(AppUserDto::fromEntity).collect(Collectors.toList());
	}

	public AppUserDto findUser(UUID id) {
		return AppUserDto.fromEntity(userRepository.findById(id).get());
	}

	public AppUserDto addUser(AppUserRegisterDto userToAdd){
		AppUser newUser = AppUser.builder()
							.firstName(userToAdd.getFirstName())
							.lastName(userToAdd.getLastName())
							.email(userToAdd.getEmail())
							.phoneNumbers(userToAdd.getPhoneNumbers())
							.passwd(encoder.encode(userToAdd.getPasswordPlain()))
							.build();

		userRepository.save(newUser);
		return AppUserDto.fromEntity(newUser);
	}

    
}