package com.jakuza.appuserservice.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AppUser {
    @Id
    @GeneratedValue
    private Long id;
    
    private String firstName;
    
    private String lastName;

    @ManyToOne
    private Address address;

    private String passwd;

    @Column(unique = true, nullable = false)
    private String email;
    
    @ElementCollection
    @Singular
    private Set<String> phoneNumbers;

    private LocalDateTime added;
}