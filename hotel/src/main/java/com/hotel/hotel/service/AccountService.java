package com.hotel.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.Account;
import com.hotel.hotel.model.Staff;
import com.hotel.hotel.repository.AccountRepository;
import com.hotel.hotel.repository.StaffRepository;
import com.hotel.hotel.request.AccountRequest;
import com.hotel.hotel.request.ChangePasswordRequest;
import com.hotel.hotel.request.LoginRequest;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private StaffRepository staffRepo;
    public ResponseEntity<List<Account>> getAllAccount() 
    {
        return new ResponseEntity<>(accountRepo.findAll(), HttpStatus.OK);
    }

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


    public ResponseEntity<Account> changePassword(int id, ChangePasswordRequest request)
    {
        Account account= accountRepo.findById(id).orElse(null);
        System.out.println(request.getOldPassword());
       
        if(account==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        System.out.println(account.getPassword());
        if(!request.getOldPassword().equals(account.getPassword()))
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        account.setPassword(request.getNewPassword());
        accountRepo.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    } 

    public ResponseEntity<Account> createAccount(AccountRequest request) 
    {
        Staff staff= staffRepo.findById(request.getStaffId()).orElse(null);
        if(staff==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        Account account = accountRepo.findByStaff(staff);
        if(account!=null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Account newAccount= new Account(request.getEmail(), request.getPassword(), staff,0);
        accountRepo.save(newAccount);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

}
