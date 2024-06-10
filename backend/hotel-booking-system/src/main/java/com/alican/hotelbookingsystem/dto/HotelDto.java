package com.alican.hotelbookingsystem.dto;

import com.alican.hotelbookingsystem.model.Hotel;
import com.alican.hotelbookingsystem.model.Location;

public record HotelDto(
    Long id,
    String name,
    String imageUrl,
    LocationDto location
) {
    public static HotelDto convert(Hotel from) {
        return new HotelDto(
                from.getId(),
                from.getName(),
                from.getImageUrl(),
                LocationDto.convert(from.getLocation()));
    }
}
