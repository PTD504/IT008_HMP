package com.hotel.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.hotel.model.Guest;
import java.util.List;


@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> { 
    public Guest findByCitizenId(String citizenId);

}
