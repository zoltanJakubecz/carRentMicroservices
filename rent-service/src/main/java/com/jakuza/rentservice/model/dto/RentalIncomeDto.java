package com.jakuza.rentservice.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RentalIncomeDto {
    
    private UUID car_id;
    
    private UUID user_id;

    private LocalDateTime rentFrom;

    private LocalDateTime rentTo;

}
