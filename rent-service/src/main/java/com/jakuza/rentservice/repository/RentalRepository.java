package com.jakuza.rentservice.repository;

import java.util.List;

import com.jakuza.rentservice.model.Rental;
import com.jakuza.rentservice.model.dto.RentalDto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
    public List<RentalDto> findAllByCarId(Long car_id);
}
