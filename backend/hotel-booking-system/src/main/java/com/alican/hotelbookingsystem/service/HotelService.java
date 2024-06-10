package com.alican.hotelbookingsystem.service;

import com.alican.hotelbookingsystem.dto.HotelDto;
import com.alican.hotelbookingsystem.model.Hotel;
import com.alican.hotelbookingsystem.model.Location;
import com.alican.hotelbookingsystem.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<HotelDto> findHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(HotelDto::convert)
                .toList();
    }

    public Hotel findHotelById(Long id) {
        return hotelRepository
                .findById(id)
                .orElse(null);
    }
}
