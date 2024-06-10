package com.alican.hotelbookingsystem.dto;

import com.alican.hotelbookingsystem.model.Room;

import java.util.Date;

public record RoomDto(
    Long id,
    String checkInDate,
    String checkOutDate,
    int roomCapacity,
    double price,
    HotelDto hotel
) {
}
