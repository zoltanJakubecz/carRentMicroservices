package com.jakuza.rentservice;

import java.time.LocalDateTime;
import java.util.UUID;

import com.jakuza.rentservice.model.Rental;
import com.jakuza.rentservice.repository.RentalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private RentalRepository rentRepository;

    @Override
    public void run(String... args) throws Exception {

        Rental rent1 = Rental.builder()
        .carId(UUID.fromString("53ff397d-a787-4350-9597-acb8f93859b4"))
        .userId(UUID.fromString("20e219c3-1d2b-4251-a1e7-dd55ba85a4b7"))
        .rentFrom(LocalDateTime.of(2020, 1, 12, 8, 15))
        .rentTo(LocalDateTime.of(2020, 1, 15, 8, 15))
        .added(LocalDateTime.now())
        .build();

        rentRepository.save(rent1);

    }
    
}
