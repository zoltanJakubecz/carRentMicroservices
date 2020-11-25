package com.jakuza.appuserservice;

import java.time.LocalDateTime;

import com.jakuza.appuserservice.model.Address;
import com.jakuza.appuserservice.model.AppUser;
import com.jakuza.appuserservice.repository.AddressRepository;
import com.jakuza.appuserservice.repository.AppUserRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

// @Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    private final AppUserRepository userRepo;

    private final AddressRepository addressRepo;

    @Override
    public void run(String... args) throws Exception {

    AppUser rentAppUser1 = AppUser.builder()
        .firstName("Zotyi")
        .lastName("Motyi")
        .phoneNumber("777-6666")
        .email("kakadu@kukadu.com")
        .passwd(passwordEncoder.encode("password"))
        .added(LocalDateTime.now())
        .build();

    AppUser rentAppUser2 = AppUser.builder()
        .firstName("Elemer")
        .lastName("Lapos")
        .email("zulu@makker.hu")
        .passwd(passwordEncoder.encode("password"))
        .phoneNumber("999-6666")
        .added(LocalDateTime.now())
        .build();

    Address address1 = Address.builder()
        .country("Hungary")
        .city("Gyula")
        .street("Ady")
        .houseNumber("36")
        .zipCode("5700")
        .rentAppUser(rentAppUser1)
        .rentAppUser(rentAppUser2)
        .build();

    rentAppUser1.setAddress(address1);
    rentAppUser2.setAddress(address1);

    
    
    addressRepo.save(address1);
    userRepo.save(rentAppUser1);
    userRepo.save(rentAppUser2);

    }
    
}