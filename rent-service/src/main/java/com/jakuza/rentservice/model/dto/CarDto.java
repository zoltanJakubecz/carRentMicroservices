package com.jakuza.rentservice.model.dto;

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

}