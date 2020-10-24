package com.jakuza.appuserservice.model;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {

    @Id
    @GeneratedValue
    private UUID id;

    private String country;

    private String city;
    
    @Singular
    @OneToMany(mappedBy = "address")
    @EqualsAndHashCode.Exclude
    private Set<AppUser> rentAppUsers;
    
    private String street;
    
    private String houseName;
    
    private String houseNumber;
    
    private String zipCode;
}
