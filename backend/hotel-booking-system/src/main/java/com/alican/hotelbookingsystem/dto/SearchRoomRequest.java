package com.alican.hotelbookingsystem.dto;

public record SearchRoomRequest(
        Long locationId,
        String checkInDate,
        String checkOutDate,
        int roomCapacity
) {
}
