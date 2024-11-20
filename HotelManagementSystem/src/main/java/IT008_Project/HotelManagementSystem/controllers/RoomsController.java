package IT008_Project.HotelManagementSystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import IT008_Project.HotelManagementSystem.dtos.RoomsCreationRequest;
import IT008_Project.HotelManagementSystem.dtos.RoomsUpdationRequest;
import IT008_Project.HotelManagementSystem.models.Rooms;
import IT008_Project.HotelManagementSystem.services.RoomsService;

@RestController
public class RoomsController { 
    @Autowired 
    private RoomsService roomsService; 

    @GetMapping("/rooms/get_all") 
    public ResponseEntity<List<Rooms>> getAllRoom() 
    {
        return roomsService.getAllRooms();
    } 

    @GetMapping("/rooms/get_by_id/{id}") 
    public ResponseEntity<Rooms> getRoomById(@PathVariable int id) 
    { 
        return roomsService.getRoomById(id);
    } 

    @PostMapping("/rooms/create") 
    public ResponseEntity<Rooms> createRoom(@RequestBody RoomsCreationRequest request ) 
    { 
        return roomsService.createNewRoom(request); 
    } 
    @PutMapping("/rooms/update") 
    public ResponseEntity<Rooms> updateRoom(@RequestBody RoomsUpdationRequest request) 
    { 
        return roomsService.updateRoom(request);
    } 
    @DeleteMapping("/rooms/delete/{id}") 
    public ResponseEntity<Rooms> deleteRoom(@PathVariable int id) 
    { 
        return roomsService.deleteRoom(id);
    }

}
