package com.alican.hotelbookingsystem.dto;

public record BookingRoomRequest(
        Long id,
        String checkInDate,
        String checkOutDate
) {
}
