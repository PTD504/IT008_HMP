package IT008_Project.HotelManagementSystem.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import IT008_Project.HotelManagementSystem.dtos.BookingsCreationRequest;
import IT008_Project.HotelManagementSystem.models.Bookings;
import IT008_Project.HotelManagementSystem.models.Guest;
import IT008_Project.HotelManagementSystem.models.Rooms;
import IT008_Project.HotelManagementSystem.repositories.BookingsRepository;
import IT008_Project.HotelManagementSystem.repositories.GuestRepository;
import IT008_Project.HotelManagementSystem.repositories.RoomsRepository;
import IT008_Project.HotelManagementSystem.repositories.ServiceRepository;
import IT008_Project.HotelManagementSystem.response.BookingResponse;
import IT008_Project.HotelManagementSystem.response.Response;

@Service
public class BookingsService { 
    @Autowired
    private BookingsRepository bookingsRepo; 
    @Autowired 
    private GuestRepository guestRepo; 
    @Autowired 
    private RoomsRepository roomRepo;  
    @Autowired 
    private ServiceRepository serviceRepo;

    public ResponseEntity<Response> newBooking(BookingsCreationRequest request) 
    {   
        IT008_Project.HotelManagementSystem.models.Service service = serviceRepo.findById(request.getServiceId()).orElse(null);
        if(service==null) 
        {
            return new ResponseEntity<>(new Response(null,"Khong ton tai dich vu"), HttpStatus.NOT_FOUND);
        }
        Rooms room = roomRepo.findById(request.getRoomId()).orElse(null); 
        if(room==null) 
        { 
            return new ResponseEntity<>(new Response(null,"Phong khong ton tai"), HttpStatus.NOT_FOUND);
        } 
        if(room.getRoom_Status()!=true) 
        {
            return new ResponseEntity<>(new Response(null,"Phong da duoc dat"), HttpStatus.BAD_REQUEST);
        }
        Guest guest = guestRepo.findByIdentityCard(request.getGuestRequest().getGuestIdentityCardId());
        if(guest==null) 
        {
            int newId = guestRepo.findAll().size()+1;
            Guest newGuest = new Guest(newId, request.getGuestRequest() ); 
            guest= newGuest;
            guestRepo.save(newGuest);
        }
        else {
            guest.setName(request.getGuestRequest().getName()); 
            guest.setAddress(request.getGuestRequest().getAddress()); 
            guest.setBirth(request.getGuestRequest().getBirthDate()); 
            guest.setEmail(request.getGuestRequest().getEmail());  
            guest.setPhoneNumber(request.getGuestRequest().getPhoneNumber());
            guestRepo.save(guest);
        }
        int newBookingId = bookingsRepo.findAll().size()+1;
        Bookings newBookings= new Bookings(newBookingId,guest,room,service, request.getCheckinDate(), request.getCheckoutDate(),request.getTotalPrice());
        bookingsRepo.save(newBookings);
        return new ResponseEntity<>(new Response(newBookings,"Dat phong thanh cong"), HttpStatus.OK);

    }
}
