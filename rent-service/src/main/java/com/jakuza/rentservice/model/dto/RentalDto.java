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
public class RentalDto {

    private Long id;

    private Long car_id;
    
    private LocalDateTime rentFrom;

    private LocalDateTime rentTo;

}
