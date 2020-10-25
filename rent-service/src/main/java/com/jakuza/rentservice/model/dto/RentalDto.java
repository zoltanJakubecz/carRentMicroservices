package com.jakuza.rentservice.model.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.jakuza.rentservice.model.Rental;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RentalDto {

    private UUID car_id;
    
    private LocalDateTime rentFrom;

    private LocalDateTime rentTo;

    public static RentalDto fromEntity(Rental rental){
        return RentalDto.builder()
                .car_id(rental.getCar_id())
                .rentFrom(rental.getRentFrom())
                .rentTo(rental.getRentTo())
                .build();
    }

}
