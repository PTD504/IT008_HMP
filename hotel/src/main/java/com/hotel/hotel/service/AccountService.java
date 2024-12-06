package com.hotel.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.Account;
import com.hotel.hotel.repository.AccountRepository;
import com.hotel.hotel.request.LoginRequest;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepo;

    public ResponseEntity<Account> login(LoginRequest request) 
    {
        Account account = accountRepo.findByEmail(request.getEmail());
        if(account==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
        if(!account.getPassword().equals(request.getPassword())) 
        {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }  
        System.out.println("Success");
        return new ResponseEntity<>(account, HttpStatus.OK);

    }

}
