package IT008_Project.HotelManagementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import IT008_Project.HotelManagementSystem.dtos.RoomsCreationRequest;
import IT008_Project.HotelManagementSystem.dtos.RoomsUpdationRequest;
import IT008_Project.HotelManagementSystem.models.RoomTypes;
import IT008_Project.HotelManagementSystem.models.Rooms;
import IT008_Project.HotelManagementSystem.repositories.RoomTypesRepository;
import IT008_Project.HotelManagementSystem.repositories.RoomsRepository;

@Service
public class RoomsService { 
    @Autowired 
    private RoomsRepository roomsRepo;  
    @Autowired 
    private RoomTypesRepository roomTypesRepo;

    public ResponseEntity<List<Rooms>> getAllRooms() 
    { 
        return new ResponseEntity<>(roomsRepo.findAll(), HttpStatus.OK);
    } 

    public ResponseEntity<Rooms> getRoomById(int id) 
    {  
        Rooms room = roomsRepo.findById(id).orElse(null); 
        if(room==null) 
        { 
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(room, HttpStatus.OK);
    } 

    public ResponseEntity<Rooms> createNewRoom(RoomsCreationRequest request) 
    {
        RoomTypes roomTypes = roomTypesRepo.findById(request.getRoom_Type()).orElse(null); 
        if(roomTypes==null) 
        { 
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        int newRoomId = roomsRepo.findAll().size()+1; 
        Rooms newRooms = new Rooms(newRoomId, request.getRoom_Number(), request.getFloor(), roomTypes, request.getRoom_Status()); 
        roomsRepo.save(newRooms); 
        return new ResponseEntity<>(newRooms, HttpStatus.OK);
    } 

    public ResponseEntity<Rooms> updateRoom(RoomsUpdationRequest request) 
    {  
        Rooms room = roomsRepo.findById(request.getId()).orElse(null); 
        if(room==null) 
        { 
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } 
        RoomTypes roomType= roomTypesRepo.findById(request.getRoom_Type()).orElse(null); 
        if(roomType==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } 
        room.setRoom_Number(request.getRoom_Number()); 
        room.setFloor(request.getFloor()); 
        room.setRoom_Status(request.getRoom_Status()); 
        room.setRoom_Type(roomType);
        roomsRepo.save(room);
        return new ResponseEntity<>(room, HttpStatus.OK);
    } 

    public ResponseEntity<Rooms> deleteRoom(int id) 
    { 
        Rooms room = roomsRepo.findById(id).orElse(null); 
        if(room==null) 
        { 
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } 
        room.setRoom_Status(false);  
        return new ResponseEntity<>(room, HttpStatus.OK);

    }

}
