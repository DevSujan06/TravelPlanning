package com.travelplanner.repository;

import com.travelplanner.model.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FlightRepository extends MongoRepository<Flight, String> {
    List<Flight> findByDestinationAndDepartureDate(String destination, String departureDate);
}
