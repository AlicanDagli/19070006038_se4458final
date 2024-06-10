package com.alican.hotelbookingsystem.dto;

import com.alican.hotelbookingsystem.model.Location;

public record LocationDto(
    Long id,
    String country,
    String city,
    String district
) {
    public static LocationDto convert(Location from) {
        return new LocationDto(
                from.getId(),
                from.getCountry(),
                from.getCity(),
                from.getDistrict()
        );
    }
}
