package com.jakuza.carservices;

import java.time.LocalDateTime;

import com.jakuza.carservices.model.Car;
import com.jakuza.carservices.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitilaizer implements CommandLineRunner {

    @Autowired
    CarRepository carRepository;

    @Override
    public void run(String... args) throws Exception {
        Car trabant = Car.builder()
            .brand("Trabant")
            .model("601")
            .regPlate("ZOZ-531")
            .active(true)
            .added(LocalDateTime.now())
            .build();

        Car bmw = Car.builder()
            .brand("BMW")
            .model("330i")
            .regPlate("ZOL-531")
            .active(true)
            .added(LocalDateTime.now())
            .build();

        carRepository.save(trabant);
        carRepository.save(bmw);

    }
    
}