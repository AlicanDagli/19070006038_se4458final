package com.alican.hotelbookingsystem.service;

import com.alican.hotelbookingsystem.dto.LocationDto;
import com.alican.hotelbookingsystem.exception.LocationNotFoundException;
import com.alican.hotelbookingsystem.model.Location;
import com.alican.hotelbookingsystem.repository.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<LocationDto> findByCityOrDistrict(String search) {
        return locationRepository.findByCityContainsOrDistrictContains(search, search)
                .stream()
                .map(LocationDto::convert)
                .toList();
    }

    public List<LocationDto> findAll() {
        return locationRepository
                .findAll()
                .stream()
                .map(LocationDto::convert)
                .toList();
    }

    protected Location findLocationById(Long id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new LocationNotFoundException("Location not found with id: " + id));
    }
}
