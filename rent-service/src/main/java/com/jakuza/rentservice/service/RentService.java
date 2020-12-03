package com.jakuza.rentservice.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jakuza.rentservice.model.Rental;
import com.jakuza.rentservice.model.dto.RentalDto;
import com.jakuza.rentservice.model.dto.RentalIncomeDto;
import com.jakuza.rentservice.repository.RentalRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RentService {

	private final RentalRepository rentalRepository;
	
	public List<RentalDto> getRents(){
		return rentalRepository.findAll().stream().map(RentalDto::fromEntity).collect(Collectors.toList());
	}

	public List<RentalDto> getRentsForCar(UUID car_id) {
		return rentalRepository.findByCarId(car_id).stream().map(RentalDto::fromEntity).collect(Collectors.toList());
	}
	
	public RentalDto addRental(RentalIncomeDto rental){
		return RentalDto.fromEntity(rentalRepository.save(Rental.builder()
															.carId(rental.getCar_id())
															.userId(rental.getUser_id())
															.rentFrom(rental.getRentFrom())
															.rentTo(rental.getRentTo())
															.added(LocalDateTime.now())
															.build()));
	}
}
