package com.alican.hotelbookingsystem.dto;

public record SaveRoomRequest(
        Long hotelId,
        String checkInDate,
        String checkOutDate,
        Integer roomNumber,
        Double dailyPrice,
        Integer roomCapacity
) {
}
