package com.jakuza.carservices.controller;

import java.util.List;

import com.jakuza.carservices.model.dto.CarDto;
import com.jakuza.carservices.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/cars")
public class CarController {
    
    @Autowired
    private CarService carService;


    @GetMapping
    public ResponseEntity<List<CarDto>> getCars(){
        return ResponseEntity.ok().body(carService.getCars());
    }

    @PostMapping
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto car){
        return ResponseEntity.ok(carService.addCar(car));
    }


    @GetMapping("/{carId}")
    public ResponseEntity<CarDto> getCar(@PathVariable Long carId){
        return ResponseEntity.ok(carService.getCar(carId));
    }


    @PutMapping("/{carId}")
    public ResponseEntity<CarDto> updateCar(@PathVariable Long carId, @RequestBody CarDto car){
        return ResponseEntity.ok(carService.updateCar(carId, car));
    }
    
}