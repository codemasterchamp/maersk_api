package com.maersk.bookapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maersk.bookapi.model.Bookings;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Long>{

}
