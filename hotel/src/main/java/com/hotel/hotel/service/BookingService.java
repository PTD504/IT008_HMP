package com.hotel.hotel.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.hotel.hotel.model.Booking;
import com.hotel.hotel.model.Guest;
import com.hotel.hotel.model.Room;
import com.hotel.hotel.repository.BookingRepository;
import com.hotel.hotel.repository.GuestRepository;
import com.hotel.hotel.repository.RoomRepository;
import com.hotel.hotel.request.addBookingRequest;
import com.hotel.hotel.response.BookingResponse;



@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository; 
    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private GuestRepository guestRepo;

    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        // Gọi phương thức tùy chỉnh từ repository
        List<BookingResponse> listRes = new ArrayList<>();
        List<Booking> listBookings=bookingRepository.findAll(); 
        for(int i=0;i<listBookings.size();i++) 
        {
           listRes.add(new BookingResponse(listBookings.get(i)));
        }
        // Trả về ResponseEntity
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }

    public ResponseEntity<addBookingRequest> addBooking(addBookingRequest request) 
    {
        Room room = roomRepo.findById(request.getRoomId()).orElse(null);
        if(room==null||room.getState()!=0)
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Guest guest = guestRepo.findByCitizenId(request.getCitizenId());
        if(guest==null) 
        { 
            int newId= guestRepo.findAll().size()+1;
            guest= new Guest(newId, request.getCitizenId(), request.getGuestName(), request.getPhone(), request.getEmail(), request.getDob(), request.getGender(), request.getAddress());
            
        }
         
        int newBookingId= bookingRepository.findAll().size()+1; 
        LocalDate ciDate=request.getCheckinDate().toLocalDate();
        LocalDate coDate=request.getCheckoutDate().toLocalDate();
        int distance= (int)ChronoUnit.DAYS.between(ciDate, coDate);
        int price= room.getRoomType().getPrice()*distance;
        Booking newBooking = new Booking(newBookingId, room, guest, null, request.getCheckinDate(), request.getCheckoutDate(), false, price); 
        room.setState(1); 
        roomRepo.save(room);
        guestRepo.save(guest);
        bookingRepository.save(newBooking); 
        return new ResponseEntity<>(request, HttpStatus.OK);


    }
}