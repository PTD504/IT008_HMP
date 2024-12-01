package com.hotel.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.hotel.model.StaffType;

@Repository
public interface StaffTypeRepository extends JpaRepository<StaffType, Integer>{

}
