package com.jakuza.rentservice.controller;

import java.util.List;
import java.util.UUID;

import com.jakuza.rentservice.model.dto.RentalDto;
import com.jakuza.rentservice.model.dto.RentalIncomeDto;
import com.jakuza.rentservice.service.RentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentController {

    @Autowired
    private RentService rentService;

    @GetMapping("/")
    public ResponseEntity<List<RentalDto>> getRents(){
        return ResponseEntity.ok().body(rentService.getRents());
    }
    
    @GetMapping("/{car_id}")
    public ResponseEntity<List<RentalDto>> getRentsForCar(@PathVariable UUID car_id){
        return ResponseEntity.ok().body(rentService.getRentsForCar(car_id));
    }

    @PostMapping("/")
    public ResponseEntity<RentalDto> addRental(@RequestBody RentalIncomeDto newRental){
        return ResponseEntity.ok().body(rentService.addRental(newRental));
    }

}
