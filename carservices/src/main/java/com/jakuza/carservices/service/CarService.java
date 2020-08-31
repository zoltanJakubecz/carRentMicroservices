package com.jakuza.carservices.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.jakuza.carservices.model.Car;
import com.jakuza.carservices.model.dto.CarDto;
import com.jakuza.carservices.repository.CarRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<CarDto> getCars(){

        return carRepository.findAll().stream().map(CarDto::fromEntity).collect(Collectors.toList());
    }

	public CarDto addCar(CarDto car) {
        
        Car newCar = Car.builder()
            .brand(car.getBrand())
            .model(car.getModel())
            .regPlate(car.getRegPlate())
            .added(LocalDateTime.now())
            .active(true)
            .build();
        
        log.info("New car added: " + newCar.toString());
        
        
        return CarDto.fromEntity(carRepository.save(newCar));
	}

	public CarDto getCar(Long id) {

        return carRepository
            .findById(id)
            .map(CarDto::fromEntity)
            .orElse(null);
	}

    @Transactional
    public CarDto updateCar(Long carId, CarDto car) {
        Car toUpdate = carRepository.findById(carId).orElse(null);
        if(toUpdate == null) return null;
        toUpdate.setBrand(car.getBrand());
        toUpdate.setModel(car.getModel());
        toUpdate.setRegPlate(car.getRegPlate());
        toUpdate.setImage(car.getImage());
        toUpdate.setActive(car.isActive());
        
		return CarDto.fromEntity(toUpdate);
	}

    
}