package com.hotel.hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.hotel.hotel.model.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
     
}
