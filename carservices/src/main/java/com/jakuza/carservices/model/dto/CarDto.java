package com.jakuza.carservices.model.dto;

import com.jakuza.carservices.model.Car;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CarDto {

    private Long id;

    private String brand;
    
    private String model;
    
    private String regPlate;

    private String image;

    private boolean active;

    public static CarDto fromEntity(Car car){
        
        return CarDto.builder()
            .id(car.getId())
            .brand(car.getBrand())
            .model(car.getModel())
            .regPlate(car.getRegPlate())
            .image(car.getImage())
            .active(car.isActive())
            .build();
    }
    
}