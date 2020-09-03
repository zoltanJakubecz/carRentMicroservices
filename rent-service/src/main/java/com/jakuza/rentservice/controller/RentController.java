package com.jakuza.rentservice.controller;

import java.util.List;

import com.jakuza.rentservice.model.dto.RentalDto;
import com.jakuza.rentservice.service.RentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rent")
public class RentController {

    @Autowired
    private RentService rentService;
    
    @GetMapping
    public ResponseEntity<List<RentalDto>> getRentsForCar(Long car_id){
        return ResponseEntity.ok().body(rentService.getRentsForCar(car_id));
    }

}
