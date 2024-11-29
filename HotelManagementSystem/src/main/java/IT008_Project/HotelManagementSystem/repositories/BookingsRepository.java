package IT008_Project.HotelManagementSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import IT008_Project.HotelManagementSystem.models.Bookings;

@Repository
public interface BookingsRepository extends JpaRepository<Bookings, Integer> { 
    List<Bookings> findByBookingId(int bookingId);

}
