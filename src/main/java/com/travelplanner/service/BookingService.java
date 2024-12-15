package com.travelplanner.service;

import com.travelplanner.model.Booking;
import com.travelplanner.model.Flight;
import com.travelplanner.model.Hotel;
import com.travelplanner.repository.BookingRepository;
import com.travelplanner.repository.FlightRepository;
import com.travelplanner.repository.HotelRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private static BookingRepository bookingRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private HotelRepository hotelRepository;
    public static List<Booking> getBookingsByUserId(String userId) {
        return bookingRepository.findByUserId(userId);
    }
 

    // Book a flight
    public Booking bookFlight(String flightId, String passengerName, int seats) throws Exception {
        // Fetch the flight
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new Exception("Flight not found"));

        // Check seat availability
        if (flight.getAvailableSeats() < seats) {
            throw new Exception("Not enough seats available");
        }

        // Deduct seats from the flight
        flight.setAvailableSeats(flight.getAvailableSeats() - seats);
        flightRepository.save(flight);

        // Create a flight booking
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setPassengerName(passengerName);
        booking.setSeats(seats);

        return bookingRepository.save(booking);
    }

    // Book a hotel
    public Booking bookHotel(String hotelId, String guestName, int nights) throws Exception {
        // Fetch the hotel
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new Exception("Hotel not found"));

        // Create a hotel booking
        Booking booking = new Booking();
        booking.setHotel(hotel);
        booking.setPassengerName(guestName); // Using passengerName field for guest name
        booking.setNights(nights);

        return bookingRepository.save(booking);
    }
}
