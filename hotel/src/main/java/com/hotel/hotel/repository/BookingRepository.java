package com.hotel.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotel.hotel.model.Booking;
import com.hotel.hotel.response.BookingResponse;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
     @Query("SELECT new com.example.response.BookingResponse(" +
            "b.id, r.id, r.roomNumber, r.state, r.floor, r.price, r.size, rt.roomTypeText, bd.bedDetailText, " +
            "g.id, g.name, g.citizenId, g.phone, g.email, g.dob, g.gender, g.address, " +
            "s.id, s.name, b.checkinDate, b.checkoutDate, b.isPaid, b.totalPrice) " +
            "FROM Booking b " +
            "JOIN b.room r " +
            "JOIN r.roomType rt " +
            "JOIN r.bedDetail bd " +
            "JOIN b.guest g " +
            "JOIN b.staff s")
    List<BookingResponse> findAllBookings();
}
