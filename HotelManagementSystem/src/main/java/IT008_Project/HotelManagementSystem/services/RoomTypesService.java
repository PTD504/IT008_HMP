package IT008_Project.HotelManagementSystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import IT008_Project.HotelManagementSystem.dtos.RoomTypeCreationRequest;
import IT008_Project.HotelManagementSystem.models.RoomTypes;
import IT008_Project.HotelManagementSystem.repositories.RoomTypesRepository;

@Service
public class RoomTypesService { 
    @Autowired 
    private RoomTypesRepository roomTypesRepo; 

    public ResponseEntity<List<RoomTypes>>getAllRoomTypes() 
    { 
        List<RoomTypes> listRoomTypes= roomTypesRepo.findAll();  
        return new ResponseEntity<>(listRoomTypes, HttpStatus.OK);
    } 

    public ResponseEntity<RoomTypes> getById(int id) 
    { 
        RoomTypes roomType= roomTypesRepo.findById(id).orElse(null);  
        if(roomType==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } 
        return new ResponseEntity<>(roomType, HttpStatus.OK);
    } 

    public ResponseEntity<RoomTypes> createNewRoomType(RoomTypeCreationRequest request)
    { 
        int newId= roomTypesRepo.findAll().size()+1; 
        RoomTypes newRoomType= new RoomTypes(newId, request.getType_Name(), request.getType_Room_Price(), request.getCapacity());
        roomTypesRepo.save(newRoomType); 
        return new ResponseEntity<>(newRoomType, HttpStatus.OK);
    }

    public ResponseEntity<RoomTypes> updateRoomType(RoomTypes roomType) 
    {
        RoomTypes oldRoomType= roomTypesRepo.findById(roomType.getId()).orElse(null); 
        if(oldRoomType==null) 
        { 
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } 
        oldRoomType.setType_Name(roomType.getType_Name()); 
        oldRoomType.setType_Room_Price(roomType.getType_Room_Price()); 
        oldRoomType.setCapacity(roomType.getCapacity()); 
        roomTypesRepo.save(oldRoomType); 
        return new ResponseEntity<>(oldRoomType, HttpStatus.OK);
    } 


    public ResponseEntity<RoomTypes> deleteRoomType(int id) 
    { 
        RoomTypes roomType= roomTypesRepo.findById(id).orElse(null); 
        if(roomType==null) 
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } 
        roomType.setCapacity(0);  
        return new ResponseEntity<>(roomType, HttpStatus.OK);
    }

    

}
 