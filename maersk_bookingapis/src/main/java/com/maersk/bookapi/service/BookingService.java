package com.maersk.bookapi.service;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.maersk.bookapi.model.Bookings;
import com.maersk.bookapi.repository.BookingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.maersk.bookapi.service.IBookingService;

@Service
public class BookingService implements IBookingService {
    
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    ConsumeWebService consumeWebService;

	@Override
	public List<Bookings> findAll() {
		return bookingRepository.findAll();
	}

	@Override
	public Bookings book(Bookings bookings) {
		try {
			if(consumeWebService.checkAvaiability()) {
				bookings.setTimestamp(ZonedDateTime.now());
				Bookings bookings = bookingRepository.save(bookings);
				return bookings;
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		throw new MaerskRuntimeException("Something Went Wrong");
	}

	@Override
	public Map<String, String> findById(String bookingId) {
		Bookings bookings =  bookingRepository.findById(bookingId).orElseThrow(() -> new DataNotFoundException("Booking", "uuid", bookingId));        
		
		HashMap<String, Boolean> result = new HashMap<>();
		result.put("bookingRef", bookings.getId()); 
		return result;
	
	}

}