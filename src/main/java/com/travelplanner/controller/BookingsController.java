package com.travelplanner.controller;

import com.travelplanner.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingsController {

    @Autowired
    private BookingService bookingService;

    // Render the booking page for a specific flight
    @GetMapping("/flight/{id}")
    public String bookFlight(@PathVariable String id, Model model) {
        if (id == null || id.isEmpty()) {
            model.addAttribute("error", "Invalid Flight ID.");
            return "error";
        }
        model.addAttribute("flightId", id); // Add flight ID to the model
        return "book-flight"; // Redirects to book-flight.html
    }

    // Render the booking page for a specific hotel
    @GetMapping("/hotel/{id}")
    public String bookHotel(@PathVariable String id, Model model) {
        if (id == null || id.isEmpty()) {
            model.addAttribute("error", "Invalid Hotel ID.");
            return "error";
        }
        model.addAttribute("hotelId", id); // Add hotel ID to the model
        return "book-hotel"; // Redirects to book-hotel.html
    }

    // Handle flight booking confirmation
    @PostMapping("/confirm/flight")
    public String confirmFlightBooking(
            @RequestParam String passengerName,
            @RequestParam int seats,
            @RequestParam String flightId,
            Model model
    ) {
        try {
            bookingService.bookFlight(flightId, passengerName, seats);
            model.addAttribute("message", "Flight booking confirmed for " + passengerName +
                    " with " + seats + " seat(s) on flight ID: " + flightId);
        } catch (Exception e) {
            model.addAttribute("message", "Booking failed: " + e.getMessage());
        }
        return "booking-confirmation";
    }
    // Handle hotel booking confirmation
    @PostMapping("/confirm/hotel")
    public String confirmHotelBooking(
            @RequestParam String guestName,
            @RequestParam int nights,
            @RequestParam String hotelId,
            Model model
    ) {
        try {
            if (hotelId == null || hotelId.isEmpty() || guestName.isEmpty() || nights <= 0) {
                throw new IllegalArgumentException("Invalid booking details.");
            }

            // Call service to save booking
            bookingService.bookHotel(hotelId, guestName, nights);

            model.addAttribute("message", "Hotel booking confirmed for " + guestName +
                    " with " + nights + " night(s) at hotel ID: " + hotelId);
            return "booking-confirmation"; // Redirects to booking-confirmation.html
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}