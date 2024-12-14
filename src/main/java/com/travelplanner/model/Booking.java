package com.travelplanner.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "bookings")
public class Booking {
    @Id
    private String id;

    private String userId; // For user identification
    private Flight flight; // For flight bookings
    private Hotel hotel;   // For hotel bookings
    private String passengerName; // For flight bookings and hotel guest names
    private int seats; // Number of seats for flight bookings
    private int nights; // Number of nights for hotel bookings

    public Booking() {}

    // Constructor for flight booking
    public Booking(String userId, Flight flight, String passengerName, int seats) {
        this.userId = userId;
        this.flight = flight;
        this.passengerName = passengerName;
        this.seats = seats;
    }

    // Constructor for hotel booking
    public Booking(String userId, Hotel hotel, String passengerName, int nights) {
        this.userId = userId;
        this.hotel = hotel;
        this.passengerName = passengerName;
        this.nights = nights;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getNights() {
        return nights;
    }

    public void setNights(int nights) {
        this.nights = nights;
    }
}
