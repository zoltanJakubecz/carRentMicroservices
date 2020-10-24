package com.jakuza.appuserservice.repository;

import java.util.UUID;

import com.jakuza.appuserservice.model.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    
}