package IT008_Project.HotelManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import IT008_Project.HotelManagementSystem.dtos.AccountCreationRequest;
import IT008_Project.HotelManagementSystem.dtos.LoginRequest;
import IT008_Project.HotelManagementSystem.dtos.Request;
import IT008_Project.HotelManagementSystem.response.LoginResponse;
import IT008_Project.HotelManagementSystem.response.Response;
import IT008_Project.HotelManagementSystem.services.AccountsService;

@RestController
public class AccountController { 
    @Autowired 
    private AccountsService accountService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request)
    {
        return accountService.login(request);
    }

    @PostMapping("/create/account")
    public ResponseEntity<Response> createAccount(@RequestBody Request request) {
        if (request.getRole() < 1) {
            return new ResponseEntity<>(new Response(null, "Bạn không có quyền truy cập vào chức năng này"), HttpStatus.UNAUTHORIZED);
        }
        try {
            if (request.getRequestData() instanceof AccountCreationRequest) {
                accountService.createAccount((AccountCreationRequest) request.getRequestData());
                return new ResponseEntity<>(new Response(null, "Tài khoản được tạo thành công"), HttpStatus.OK);
            }
            return new ResponseEntity<>(new Response(null, "Thông tin sai"), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(null, "Lỗi hệ thống: " + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
