/*package IT008_Project.HotelManagementSystem.services;

import IT008_Project.HotelManagementSystem.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import IT008_Project.HotelManagementSystem.dtos.AccountCreationRequest;
import IT008_Project.HotelManagementSystem.dtos.LoginRequest;
import IT008_Project.HotelManagementSystem.dtos.Request;
import IT008_Project.HotelManagementSystem.models.Accounts;
import IT008_Project.HotelManagementSystem.models.Employee;
import IT008_Project.HotelManagementSystem.repositories.AccountsRepository;
import IT008_Project.HotelManagementSystem.repositories.EmployeeRepository;
import IT008_Project.HotelManagementSystem.response.LoginResponse;
import IT008_Project.HotelManagementSystem.response.Response;

@Service
public class AccountsService { 
    @Autowired 
    private AccountsRepository accountRepo;  
    @Autowired 
    private EmployeeRepository employeeRepo;

    @Autowired
    private SecurityConfig passwordEncoder;

    public ResponseEntity<LoginResponse> login(LoginRequest request) 
    {  
        Accounts account = accountRepo.findByUserName(request.getUserName());
        if(account==null) 
        {
            return new ResponseEntity<>(new LoginResponse(-1,-1,"Tài khoản không tồn tại"), HttpStatus.NOT_FOUND);
        }

        if(!passwordEncoder.matches(request.getPassword(), account.getPassword())) {
            return new ResponseEntity<>(new LoginResponse(-1, -1, "Thông tin đăng nhập sai"), HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(new LoginResponse(account.getEmployee().getId(), account.getEmployee().getPosition(),"Đăng nhập thành công"), HttpStatus.OK);
    }

    public ResponseEntity<Response> createAccount(AccountCreationRequest request)
    {
        
        Employee employee = employeeRepo.findById(request.getEmployeeId()).orElse(null); 
        if(employee==null) 
        { 
            return new ResponseEntity<>(new Response(null,"Nhân viên không tồn tại"),HttpStatus.NOT_FOUND);
        } 
         int newAccountId = accountRepo.findAll().size()+1;
         Accounts newAccount = new Accounts(newAccountId, request.getUserName(), passwordEncoder.encode(request.getPassword()), employee);
         accountRepo.save(newAccount);
         return new ResponseEntity<>(new Response(newAccount, "Tạo tài khoản thành công"), HttpStatus.OK);
    }

}*/
