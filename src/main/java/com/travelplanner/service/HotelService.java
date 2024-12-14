package com.travelplanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.travelplanner.dto.HotelSearchDTO;
import com.travelplanner.model.Hotel;
import com.travelplanner.repository.HotelRepository;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> searchHotels(HotelSearchDTO searchDTO) {
        return hotelRepository.findByLocationAndAvailableDates(
            searchDTO.getLocation(), searchDTO.getAvailableDates()
        );
    }
}
