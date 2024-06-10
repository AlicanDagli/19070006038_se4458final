package com.alican.hotelbookingsystem.repository;

import com.alican.hotelbookingsystem.model.Location;
import com.alican.hotelbookingsystem.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findFirst10ByRoomCapacityOrderByDailyPriceDesc(int roomCapacity);

    List<Room> findByCheckInDateBeforeAndCheckOutDateAfterAndRoomCapacityAndHotel_Location(Date checkInDate, Date checkOutDate, Integer roomCapacity, Location location);
}
