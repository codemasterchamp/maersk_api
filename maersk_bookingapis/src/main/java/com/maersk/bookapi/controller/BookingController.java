package com.maersk.bookapi.controller;

import java.util.List;

import javax.validation.Valid;

import com.maersk.bookapi.exception.DataNotFoundException;
import com.maersk.bookapi.model.BookingRequest;
import com.maersk.bookapi.model.Bookings;
import com.maersk.bookapi.repository.BookingRepository;
import com.maersk.bookapi.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@PostMapping("/bookings")
	public Bookings createBooking(@Valid @RequestBody BookingRequest request) {

		validateRequest(request);
		Bookings dto = bookingService.book(mapToDTO(request));
	    return bookingService.book(dto);
	}

	@GetMapping("/booking/{uuid}")
	public Bookings getByUUId(@PathVariable(value = "uuid") Long bookingId) {
	    return bookingService.findById(bookingId);
	}
	
	@GetMapping("/bookings")
	public List<Bookings> getAllBooks() {
	    return bookingRepository.findAll();
	}

	private validateRequest(BookingRequest request) {

		if(request == null || StringUtils.Empty(request.getContainerSize())
		   || StringUtils.Empty(request.getContainerType()) || StringUtils.Empty(request.getContainerType())
		   || StringUtils.Empty(request.getDestination()) || StringUtils.Empty(request.getQuantity()) 
		   || StringUtils.Empty(request.getOrigin()))
		   throw new InvalidParameterException();

	}

	private Bookings mapToDTO(BookingRequest request) {
		Bookings bookings= new Bookings();
		BeanUtils.copyProperties(bookings, request);
		return bookings;
	}
	

}
