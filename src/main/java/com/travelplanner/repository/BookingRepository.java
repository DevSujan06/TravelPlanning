package com.travelplanner.repository;

import com.travelplanner.model.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    // Query method to find bookings by userId
    List<Booking> findByUserId(String userId);
}
