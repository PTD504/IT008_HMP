package com.hotel.hotel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.hotel.model.Account;
import com.hotel.hotel.request.LoginRequest;
import com.hotel.hotel.service.AccountService;

@RestController
public class AccountController {
    @Autowired
    private AccountService service;

    @PostMapping("/accounts/")
    public ResponseEntity<Account> login(@RequestBody LoginRequest request)
    {
        return service.login(request);
    }
}
