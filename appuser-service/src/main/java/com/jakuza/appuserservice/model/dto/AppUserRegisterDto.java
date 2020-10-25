package com.jakuza.appuserservice.model.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AppUserRegisterDto {

    private String firstName;
    
    private String lastName;

    private String email;

    private String passwordPlain;
    
    private Set<String> phoneNumbers;

}
