package com.jakuza.rentservice.model.dto;

import java.util.Set;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AppUserDto {
    
    private Long id;
    
    private String firstName;
    
    private String lastName;

    private String passwd;

    private String email;
    
    private Set<String> phoneNumbers;

}
