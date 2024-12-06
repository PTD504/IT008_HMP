package com.hotel.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotel.hotel.model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{ 
    public Account findByEmail(String email);

}
