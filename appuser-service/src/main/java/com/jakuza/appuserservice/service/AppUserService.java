package com.jakuza.appuserservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.*;

import com.jakuza.appuserservice.model.Address;
import com.jakuza.appuserservice.model.AppUser;
import com.jakuza.appuserservice.model.dto.AppUserDto;
import com.jakuza.appuserservice.model.dto.AppUserRegisterDto;
import com.jakuza.appuserservice.repository.AddressRepository;
import com.jakuza.appuserservice.repository.AppUserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppUserService {

	private final PasswordEncoder encoder;

	private final AppUserRepository userRepository;
	
	private final AddressRepository addressRepository;

	public List<AppUserDto> getUsers() {
		return userRepository.findAll().stream().map(AppUserDto::fromEntity).collect(Collectors.toList());
	}

	public AppUserDto findUser(UUID id) {
		return AppUserDto.fromEntity(userRepository.findById(id).orElse(null));
	}

	public AppUserDto addUser(AppUserRegisterDto userToAdd){

		if(!userToAdd.getPasswordPlain().equals(userToAdd.getPasswordPlainCheck())){
			return null;
		}
		AppUser newUser = AppUser.builder()
							.firstName(userToAdd.getFirstName())
							.lastName(userToAdd.getLastName())
							.email(userToAdd.getEmail())
							.phoneNumbers(userToAdd.getPhoneNumbers())
							.passwd(encoder.encode(userToAdd.getPasswordPlain()))
							.added(LocalDateTime.now())
							.build();
		Address newAddress = Address.builder()
								.country(userToAdd.getCountry())
								.city(userToAdd.getCity())
								.street(userToAdd.getStreet())
								.houseNumber(userToAdd.getHouseNumber())
								.zipCode(userToAdd.getZipCode())
								.rentAppUser(newUser)
								.build();
		newUser.setAddress(newAddress);
		addressRepository.save(newAddress);
		userRepository.save(newUser);
		return AppUserDto.fromEntity(newUser);
	}

	public AppUserDto updateUser(UUID id, AppUserDto user) {
		return AppUserDto.fromEntity(userRepository.findById(id)
										.map((upUser) -> {
											upUser.setFirstName(user.getFirstName());
											upUser.setLastName(user.getLastName());
											upUser.setEmail(user.getEmail());
											return userRepository.save(upUser);
										})
										.orElse(null)
		);
	}

    
}