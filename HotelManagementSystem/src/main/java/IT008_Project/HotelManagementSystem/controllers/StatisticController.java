package IT008_Project.HotelManagementSystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import IT008_Project.HotelManagementSystem.response.Response;
import IT008_Project.HotelManagementSystem.services.StatisTicsService;

@RestController
public class StatisticController {
    @Autowired
    private StatisTicsService statisticService;
    @GetMapping("statistic/amount_guest/{month}/{year}") 
    public ResponseEntity<Response> statisticAmountuest(@PathVariable int month, @PathVariable int year) 
    {
        return statisticService.statisticAmountGuest(month, year);
    } 

    @GetMapping("/statistic/income/{month}/{year}") 
    public ResponseEntity<Response> statisticIncome(@PathVariable int month, @PathVariable int year) 
    {
        return statisticService.statisticIncome(month, year);
    }

}
