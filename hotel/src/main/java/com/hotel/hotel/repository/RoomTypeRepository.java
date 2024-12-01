package com.hotel.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.hotel.model.RoomType;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

}
