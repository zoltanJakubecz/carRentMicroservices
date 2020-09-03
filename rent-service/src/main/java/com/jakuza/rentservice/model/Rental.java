package com.jakuza.rentservice.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Rental {

    @Id
    @GeneratedValue
    private Long id;

    private Long car_id;
    
    private Long user_id;

    @Column(nullable = false)
    private LocalDateTime rentFrom;

    @Column(nullable = false)
    private LocalDateTime rentTo;

    private LocalDateTime added;
    
}