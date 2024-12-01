package com.hotel.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.hotel.model.Guest;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

}
