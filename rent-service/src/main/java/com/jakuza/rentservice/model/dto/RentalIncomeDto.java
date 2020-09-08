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
    
    private Long car_id;
    
    private Long user_id;

    private LocalDateTime rentFrom;

    private LocalDateTime rentTo;

}
