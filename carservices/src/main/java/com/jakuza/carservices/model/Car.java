package com.jakuza.carservices.model;

import java.time.LocalDateTime;

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
public class Car {

@Id
@GeneratedValue
private Long id;

private String brand;

private String model;

private String regPlate;

private String image;

private boolean active;

private LocalDateTime added; 
    
}