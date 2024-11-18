package IT008_Project.HotelManagementSystem.controllers;

import IT008_Project.HotelManagementSystem.models.Employee;
import IT008_Project.HotelManagementSystem.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;
}
