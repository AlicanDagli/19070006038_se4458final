package com.alican.hotelbookingsystem.controller;

import com.alican.hotelbookingsystem.dto.HotelDto;
import com.alican.hotelbookingsystem.service.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public ResponseEntity<List<HotelDto>> findHotels() {
        return ResponseEntity.ok(hotelService.findHotels());
    }
}
