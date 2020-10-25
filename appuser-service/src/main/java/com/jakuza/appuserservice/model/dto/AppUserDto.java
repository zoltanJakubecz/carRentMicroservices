package com.jakuza.appuserservice.model.dto;

import java.util.Set;
import java.util.UUID;

import com.jakuza.appuserservice.model.AppUser;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AppUserDto {
    
    private UUID id;
    
    private String firstName;
    
    private String lastName;

    private String email;
    
    private Set<String> phoneNumbers;

    public static AppUserDto fromEntity(AppUser user){

        return AppUserDto.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .phoneNumbers(user.getPhoneNumbers())
                    .build();

    }
}
