package com.jakuza.rentservice.repository;

import java.util.List;
import java.util.UUID;

import com.jakuza.rentservice.model.Rental;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, UUID> {

    List<Rental> findByCarId(UUID carId);

}
