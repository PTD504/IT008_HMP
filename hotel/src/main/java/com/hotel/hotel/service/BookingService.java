package com.hotel.hotel.service;

import java.sql.Date;
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
import com.hotel.hotel.request.BookingRenewalRequest;
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
          if(listBookings.get(i).getUsable()) 
          {
               listRes.add(new BookingResponse(listBookings.get(i)));
          }
        }
        // Trả về ResponseEntity
        return new ResponseEntity<>(listRes, HttpStatus.OK);
    }

    public ResponseEntity<addBookingRequest> addBooking(addBookingRequest request) 
    { 
       Room room = roomRepo.findById(Integer.parseInt(request.getRoomId())).orElse(null);
       if(room==null||room.getUsable()==false)
       {
          System.out.println("Room is null");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }
       room.setState(1);
       roomRepo.save(room);
       Guest guest = guestRepo.findByCitizenId(request.getCitizenId());
       if(guest==null)
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
       Staff staff = staffRepo.findById(request.getStaffId()).orElse(null);
       if(staff==null||staff.getUsable()==false)
       {
          return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
       }
       LocalDate date1= request.getCheckinDate().toLocalDate();
       LocalDate date2= request.getCheckoutDate().toLocalDate();
       int daysBetween =(int) ChronoUnit.DAYS.between(date1, date2);
       int totalPrice= daysBetween*room.getRoomType().getPrice();
       Booking newBooking = new Booking(room, guest, staff, request.getCheckinDate(), request.getCheckoutDate(), false, totalPrice);
       bookingRepository.save(newBooking);
       return new ResponseEntity<>(request, HttpStatus.OK);

    } 


    public ResponseEntity<Booking> checkIn(int bookingId) 
    {
          Booking booking = bookingRepository.findById(bookingId).orElse(null);
          if(booking==null||!booking.getUsable()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
          Room room = booking.getRoom();
          if(room.getState()!=1)
          {
               return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
          } 
          LocalDate presentDate= LocalDate.now();
          booking.setCheckinDate(new Date(presentDate.getYear()-1900, presentDate.getMonthValue()-1, presentDate.getDayOfMonth()));
          bookingRepository.save(booking);
          room.setState(2);
          roomRepo.save(room);
          return new ResponseEntity<>(booking, HttpStatus.OK);
    } 

    public ResponseEntity<Booking> checkOut(int bookingId) 
    { 
          
          Booking booking = bookingRepository.findById(bookingId).orElse(null);
          if(booking==null||!booking.getUsable()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
          Room room = booking.getRoom();

          List<Booking> listBooking = bookingRepository.findByRoom(room);  
          boolean condition=true;
          for(int i=0;i<listBooking.size();i++) 
          {
               if(listBooking.get(i).getId()!=booking.getId()) 
               {
                    if(listBooking.get(i).getRoom().getId()==booking.getRoom().getId()&&!listBooking.get(i).getIsPaid())
                    { 
                         condition=false;
                         break;
                    }
               }
          }
          if(condition) {
          room.setState(0);
          }  
          else {
               room.setState(1);
          }
          LocalDate presentDate= LocalDate.now();
          booking.setCheckoutDate(new Date(presentDate.getYear()-1900, presentDate.getMonthValue()-1, presentDate.getDayOfMonth()));
          
          roomRepo.save(room);
          booking.setIsPaid(true); 
          LocalDate date2= booking.getCheckinDate().toLocalDate();
          LocalDate date3= booking.getCheckoutDate().toLocalDate(); 
          int daysBetween =(int) ChronoUnit.DAYS.between(date2, date3);
          int totalPrice= daysBetween*room.getRoomType().getPrice();
          booking.setTotalPrice(totalPrice);
          bookingRepository.save(booking);
          return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    public ResponseEntity<Booking> renewal(int bookingId, BookingRenewalRequest request) 
    {
          Booking booking = bookingRepository.findById(bookingId).orElse(null);
          if(booking==null) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
          Room room = booking.getRoom();
          if(room.getState()!=2)
          {
               return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
          } 
          LocalDate date2= booking.getCheckinDate().toLocalDate();
          LocalDate date3= request.getNewCheckoutDate().toLocalDate(); 
          int daysBetween =(int) ChronoUnit.DAYS.between(date2, date3);
          System.out.println(daysBetween);
          int totalPrice=- daysBetween*room.getRoomType().getPrice();
          booking.setCheckoutDate(request.getNewCheckoutDate());
          booking.setTotalPrice(totalPrice);
          bookingRepository.save(booking);
          return new ResponseEntity<>(booking, HttpStatus.OK);
          

    }

    public ResponseEntity<String> checKValidNewCheckoutDate(int id, BookingRenewalRequest request) 
    {

          Booking booking  = bookingRepository.findById(id).orElse(null);
          if(booking==null)
          {
               return new ResponseEntity<>("Invalid booking", HttpStatus.BAD_REQUEST);
          }
          List<Booking> listBooking = bookingRepository.findByRoom(booking.getRoom());
          for(int i=0;i<listBooking.size();i++) 
          {
               if(listBooking.get(i).getId()!=booking.getId()&&listBooking.get(i).getUsable()) 
               {
                    if(listBooking.get(i).getCheckinDate().before(request.getNewCheckoutDate())&&listBooking.get(i).getIsPaid()==false)
                    {
                         return new ResponseEntity<>("Invalid date", HttpStatus.BAD_REQUEST);
                    }
               }
          }
          LocalDate date2= booking.getCheckinDate().toLocalDate();
          LocalDate date3= request.getNewCheckoutDate().toLocalDate(); 
          int daysBetween =(int) ChronoUnit.DAYS.between(date2, date3); 
          if (daysBetween<=0) {
               return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
               
          }
          int totalPrice=+ daysBetween*booking.getRoom().getRoomType().getPrice();
          booking.setCheckoutDate(request.getNewCheckoutDate());
          booking.setTotalPrice(totalPrice);
          bookingRepository.save(booking);
          return new ResponseEntity<>("Valid", HttpStatus.OK);

    }

    public ResponseEntity<String> deleteBooking(int id) 
    {
          Booking booking  = bookingRepository.findById(id).orElse(null);
          if(booking==null)
          {
               return new ResponseEntity<>("Invalid booking", HttpStatus.BAD_REQUEST);
          }
          Room room =booking.getRoom();
          List<Booking> listBooking = bookingRepository.findByRoom(room);  
          boolean condition=true;
          for(int i=0;i<listBooking.size();i++) 
          {
               if(listBooking.get(i).getId()!=booking.getId()) 
               {
                    if(listBooking.get(i).getRoom().getId()==booking.getRoom().getId()&&!listBooking.get(i).getIsPaid())
                    { 
                         condition=false;
                         break;
                    }
               }
          }
          if(condition) {
          room.setState(0);
          }
          roomRepo.save(room);
          booking.setUsable(false);
          bookingRepository.save(booking);
          
          return new ResponseEntity<>("Deleted booking", HttpStatus.OK);
    }
    
}