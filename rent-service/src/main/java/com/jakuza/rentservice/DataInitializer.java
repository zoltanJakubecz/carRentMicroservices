package com.jakuza.rentservice;

import java.time.LocalDateTime;

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
        .car_id(1L)
        .user_id(2L)
        .rentFrom(LocalDateTime.of(2020, 1, 12, 8, 15))
        .rentTo(LocalDateTime.of(2020, 1, 15, 8, 15))
        .added(LocalDateTime.now())
        .build();

        rentRepository.save(rent1);

    }
    
}
