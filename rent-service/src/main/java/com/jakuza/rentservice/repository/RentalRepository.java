package com.jakuza.rentservice.repository;

import java.util.List;

import com.jakuza.rentservice.model.Rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    @Query("SELECT r FROM Rental r WHERE r.car_id = :carId")
    List<Rental> findByCar_id(@Param("carId") Long car_id);
}
