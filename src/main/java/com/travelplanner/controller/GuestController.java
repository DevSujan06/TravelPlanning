package com.travelplanner.controller;

import com.travelplanner.dto.FlightSearchDTO;
import com.travelplanner.dto.HotelSearchDTO;
import com.travelplanner.model.Flight;
import com.travelplanner.model.Hotel;
import com.travelplanner.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {

    @Autowired
    private SearchService searchService;

    // Allow guests to search for flights
    @PostMapping("/search/flights")
    public ResponseEntity<List<Flight>> searchFlightsAsGuest(@RequestBody FlightSearchDTO searchCriteria) {
        List<Flight> flights = searchService.searchFlights(searchCriteria);
        return ResponseEntity.ok(flights);
    }

    // Allow guests to search for hotels
    @PostMapping("/search/hotels")
    public ResponseEntity<List<Hotel>> searchHotelsAsGuest(@RequestBody HotelSearchDTO searchCriteria) {
        List<Hotel> hotels = searchService.searchHotels(searchCriteria);
        return ResponseEntity.ok(hotels);
    }

    // Notify guests about more features if they create an account
    @GetMapping("/info")
    public ResponseEntity<String> getGuestInfo() {
        String message = "Sign up to enjoy more features like saving destinations, managing bookings, and price alerts.";
        return ResponseEntity.ok(message);
    }
}
