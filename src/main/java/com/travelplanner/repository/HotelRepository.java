package com.travelplanner.repository;

import com.travelplanner.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface HotelRepository extends MongoRepository<Hotel, String> {
    List<Hotel> findByLocationAndAvailableDates(String location, String availableDates);
}
