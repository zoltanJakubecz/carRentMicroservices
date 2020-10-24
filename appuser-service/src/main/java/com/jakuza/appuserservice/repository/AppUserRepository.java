package com.jakuza.appuserservice.repository;

import java.util.UUID;

import com.jakuza.appuserservice.model.AppUser;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {
    
}