package com.jakuza.rentservice.repository;

import com.jakuza.rentservice.model.Rental;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    
}
