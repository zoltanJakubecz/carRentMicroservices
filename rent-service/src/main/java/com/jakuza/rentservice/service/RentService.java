package com.jakuza.rentservice.service;

import java.util.List;

import com.jakuza.rentservice.model.dto.RentalDto;
import com.jakuza.rentservice.repository.RentalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentService {

    @Autowired
    private RentalRepository rentalRepository;

	public List<RentalDto> getRentsForCar(Long car_id) {
		return rentalRepository.findAllByCarId(car_id);
	}
    
}
