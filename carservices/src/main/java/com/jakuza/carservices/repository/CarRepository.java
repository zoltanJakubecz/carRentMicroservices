package com.jakuza.carservices.repository;

import com.jakuza.carservices.model.Car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
    
}