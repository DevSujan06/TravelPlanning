package com.travelplanner.dto;

public class FlightSearchDTO {
    private String destination;
    private String departureDate;
    private int passengers;
    private String arrivalDate; // Optional: To support searches with arrival date
    private String duration; // Optional: To search flights by duration

    public FlightSearchDTO() {}

    public FlightSearchDTO(String destination, String departureDate, int passengers, String arrivalDate, String duration) {
        this.destination = destination;
        this.departureDate = departureDate;
        this.passengers = passengers;
        this.arrivalDate = arrivalDate;
        this.duration = duration;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
	