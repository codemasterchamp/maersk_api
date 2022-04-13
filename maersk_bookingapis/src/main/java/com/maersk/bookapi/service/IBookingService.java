package com.maersk.bookapi.service;

import java.util.List;

import com.maersk.bookapi.model.Bookings;

public interface IBookingService {
    
    public Bookings book(Bookings bookings);

    public List<Bookings> findAll();

    public Bookings findById(String bookingId);
    
}