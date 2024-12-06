package com.hotel.hotel.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.hotel.hotel.model.Booking;
import com.hotel.hotel.model.Guest;
import com.hotel.hotel.model.Room;
import com.hotel.hotel.model.Staff;
import com.hotel.hotel.repository.BookingRepository;
import com.hotel.hotel.repository.GuestRepository;
import com.hotel.hotel.repository.RoomRepository;
import com.hotel.hotel.repository.StaffRepository;
import com.hotel.hotel.request.addBookingRequest;
import com.hotel.hotel.response.BookingResponse;

import jakarta.transaction.Transactional;



@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository; 
    @Autowired
    private RoomRepository roomRepo;
    @Autowired
    private GuestRepository guestRepo; 
    @Autowired 
    private StaffRepository staffRepo;
    @Transactional
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
       Room room = roomRepo.findById(Integer.parseInt(request.getRoomId())).orElse(null);
       if(room==null||room.getState()!=0)
       {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }
       room.setState(1);
       roomRepo.save(room);
       Guest guest = guestRepo.findByCitizenId(request.getCitizenId());
       if(guest.equals(null))
       {
            guest= new Guest(request.getCitizenId(), request.getGuestName(), request.getPhone(), request.getEmail(), request.getDob(), request.getGender(), request.getAddress());
       }
       else {
            guest.setName(request.getGuestName());
            guest.setPhone(request.getPhone());
            guest.setEmail(request.getEmail());
            guest.setDob(request.getDob());
            guest.setGender(request.getGender());
            guest.setAddress(request.getAddress());
       }
       guestRepo.save(guest);
       Staff staff = staffRepo.findById(1).orElse(null);
       LocalDate date1= request.getCheckinDate().toLocalDate();
       LocalDate date2= request.getCheckoutDate().toLocalDate();
       int daysBetween =(int) ChronoUnit.DAYS.between(date1, date2);
       int totalPrice= daysBetween*room.getRoomType().getPrice();
       Booking newBooking = new Booking(room, guest, staff, request.getCheckinDate(), request.getCheckoutDate(), false, totalPrice);
       bookingRepository.save(newBooking);
       return new ResponseEntity<>(request, HttpStatus.OK);

    }
    
}