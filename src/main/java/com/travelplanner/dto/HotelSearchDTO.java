package com.travelplanner.dto;

public class HotelSearchDTO {
    private String location;
    private String availableDates;

    public HotelSearchDTO() {}

    public HotelSearchDTO(String location, String availableDates) {
        this.location = location;
        this.availableDates = availableDates;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvailableDates() {
        return availableDates;
    }

    public void setAvailableDates(String availableDates) {
        this.availableDates = availableDates;
    }
}
