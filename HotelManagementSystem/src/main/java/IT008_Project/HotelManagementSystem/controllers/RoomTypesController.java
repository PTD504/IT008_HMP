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

import IT008_Project.HotelManagementSystem.dtos.RoomTypeCreationRequest;
import IT008_Project.HotelManagementSystem.models.RoomTypes;
import IT008_Project.HotelManagementSystem.services.RoomTypesService;

@RestController
public class RoomTypesController { 
    @Autowired 
    private RoomTypesService roomTypesService;

    @GetMapping("/room_types/get_all") 
    public ResponseEntity<List<RoomTypes>> getAllRoomTypes() 
    { 
        return roomTypesService.getAllRoomTypes();
    }  
    @GetMapping("/room_types/get_by_id/{id}")
    public ResponseEntity<RoomTypes> getRoomTypesById(@PathVariable int id) 
    { 
        return roomTypesService.getById(id);
    } 

    @PostMapping("/room_types/create") 
    public ResponseEntity<RoomTypes> createRoomType(@RequestBody RoomTypeCreationRequest request)
    { 
        return roomTypesService.createNewRoomType(request);
    } 

    @PutMapping("/room_types/update") 
    public ResponseEntity<RoomTypes> updateRoomType(@RequestBody RoomTypes roomType) 
    {
        return roomTypesService.updateRoomType(roomType);
    } 
    @DeleteMapping("/room_types/delete/{id}") 
    public ResponseEntity<RoomTypes> deleteRoomType(@PathVariable int id) 
    { 
        return roomTypesService.deleteRoomType(id);
    }


}
