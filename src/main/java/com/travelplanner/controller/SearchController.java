package com.travelplanner.controller;

import com.travelplanner.dto.FlightSearchDTO;
import com.travelplanner.dto.HotelSearchDTO;
import com.travelplanner.model.Flight;
import com.travelplanner.model.Hotel;
import com.travelplanner.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    // Handle flight search
    @PostMapping("/flights")
    public String searchFlights(@ModelAttribute FlightSearchDTO flightSearchDTO, Model model) {
        List<Flight> flights = searchService.searchFlights(flightSearchDTO);
        model.addAttribute("flights", flights); // Pass the flights to the view
        return "search-results"; // Return the search-results.html page
    }

    // Handle hotel search
    @PostMapping("/hotels")
    public String searchHotels(@ModelAttribute HotelSearchDTO hotelSearchDTO, Model model) {
        List<Hotel> hotels = searchService.searchHotels(hotelSearchDTO);
        model.addAttribute("hotels", hotels); // Pass the hotels to the view
        return "search-results"; // Return the search-results.html page
    }
}
