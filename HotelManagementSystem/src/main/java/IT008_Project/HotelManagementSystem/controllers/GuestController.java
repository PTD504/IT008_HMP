package IT008_Project.HotelManagementSystem.controllers;

import IT008_Project.HotelManagementSystem.services.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GuestController {
    @Autowired
    private GuestService service;


}
