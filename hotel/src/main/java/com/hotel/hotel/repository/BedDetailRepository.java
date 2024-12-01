package com.hotel.hotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.hotel.model.BedDetail;

@Repository
public interface BedDetailRepository extends JpaRepository<BedDetail, Integer> {

}
