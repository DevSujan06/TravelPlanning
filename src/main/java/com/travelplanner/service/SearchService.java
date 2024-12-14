package com.travelplanner.service;

import com.travelplanner.dto.FlightSearchDTO;
import com.travelplanner.dto.HotelSearchDTO;
import com.travelplanner.model.Flight;
import com.travelplanner.model.Hotel;
import com.travelplanner.repository.FlightRepository;
import com.travelplanner.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private HotelRepository hotelRepository;

    // Search for flights based on criteria
    public List<Flight> searchFlights(FlightSearchDTO searchCriteria) {
        return flightRepository.findByDestinationAndDepartureDate(
                searchCriteria.getDestination(),
                searchCriteria.getDepartureDate()
        );
    }

    // Search for hotels based on criteria
    public List<Hotel> searchHotels(HotelSearchDTO searchCriteria) {
        return hotelRepository.findByLocationAndAvailableDates(
                searchCriteria.getLocation(),
                searchCriteria.getAvailableDates()
        );
    }
}
