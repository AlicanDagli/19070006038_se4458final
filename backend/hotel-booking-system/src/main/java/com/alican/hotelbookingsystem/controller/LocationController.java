package com.alican.hotelbookingsystem.controller;

import com.alican.hotelbookingsystem.dto.LocationDto;
import com.alican.hotelbookingsystem.model.Location;
import com.alican.hotelbookingsystem.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<LocationDto>> getAllLocations() {
        return ResponseEntity.ok(locationService.findAll());
    }

    @GetMapping
    public ResponseEntity<List<LocationDto>> getLocations(@RequestParam String search) {
        return ResponseEntity.ok(locationService.findByCityOrDistrict(search));
    }
}
