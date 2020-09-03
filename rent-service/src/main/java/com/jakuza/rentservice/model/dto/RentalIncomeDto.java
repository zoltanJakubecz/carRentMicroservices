package com.jakuza.rentservice.model.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RentalIncomeDto {
    
    private Long id;

    private CarDto car;
    
    private AppUserDto user;

    private LocalDateTime rentFrom;

    private LocalDateTime rentTo;

}
