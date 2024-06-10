package com.alican.hotelbookingsystem.service;

import com.alican.hotelbookingsystem.dto.*;
import com.alican.hotelbookingsystem.exception.RoomNotFoundException;
import com.alican.hotelbookingsystem.model.Hotel;
import com.alican.hotelbookingsystem.model.Location;
import com.alican.hotelbookingsystem.model.Room;
import com.alican.hotelbookingsystem.repository.RoomRepository;
import com.alican.hotelbookingsystem.utils.DateConverter;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final LocationService locationService;
    private final HotelService hotelService;

    public RoomService(RoomRepository roomRepository, LocationService locationService, HotelService hotelService) {
        this.roomRepository = roomRepository;
        this.locationService = locationService;
        this.hotelService = hotelService;
    }

    public List<RoomDto> getRooms() {
        return roomRepository
                .findFirst10ByRoomCapacityOrderByDailyPriceDesc(1)
                .stream()
                .map(room -> {
                    long days = ChronoUnit.DAYS.between(room.getCheckInDate().toInstant(), room.getCheckOutDate().toInstant());
                    return new RoomDto(
                            room.getId(),
                            room.getCheckInDate().toString(),
                            room.getCheckOutDate().toString(),
                            room.getRoomCapacity(),
                            room.getDailyPrice() * days,
                            HotelDto.convert(room.getHotel()));
                })
                .toList();
    }

    public void saveRoom(SaveRoomRequest request) {
        Hotel hotel = hotelService.findHotelById(request.hotelId());
        Room room = Room.builder()
                .hotel(hotel)
                .checkInDate(DateConverter.convert(request.checkInDate()))
                .checkOutDate(DateConverter.convert(request.checkOutDate()))
                .roomCapacity(request.roomCapacity())
                .roomNumber(request.roomNumber())
                .dailyPrice(request.dailyPrice())
                .build();

        roomRepository.save(room);
    }

    public List<RoomDto> findRooms(SearchRoomRequest request) {
        Location location = locationService.findLocationById(request.locationId());

        Date checkInDate = DateConverter.convert(request.checkInDate());
        Date checkOutDate = DateConverter.convert(request.checkOutDate());

        long days = ChronoUnit.DAYS.between(checkInDate.toInstant(), checkOutDate.toInstant());

        List<Room> byCheckInDateAfterAndCheckOutDateBeforeAndRoomCapacityAndHotelLocation = roomRepository.findByCheckInDateBeforeAndCheckOutDateAfterAndRoomCapacityAndHotel_Location(checkInDate,
                checkOutDate,
                request.roomCapacity(),
                location);

        return roomRepository
                .findByCheckInDateBeforeAndCheckOutDateAfterAndRoomCapacityAndHotel_Location(
                        checkInDate,
                        checkOutDate,
                        request.roomCapacity(),
                        location)
                .stream()
                .map(room -> {
                    RoomDto roomDto = new RoomDto(
                            room.getId(),
                            request.checkInDate(),
                            request.checkOutDate(),
                            request.roomCapacity(),
                            room.getDailyPrice() * days,
                            HotelDto.convert(room.getHotel()));
                    return roomDto;
                })
                .toList();
    }

    public void bookingRoom(BookingRoomRequest request) {
        Room room = roomRepository.findById(request.id())
                .orElseThrow(() -> new RoomNotFoundException("Room not found by id : " + request.id()));
        if (room.getRoomNumber() < 1) {
            roomRepository.deleteById(request.id());
        } else {
            room.setRoomNumber(room.getRoomNumber() - 1);
            roomRepository.save(room);

            Room newRoom = new Room();
            newRoom.setRoomNumber(1);
            newRoom.setCheckInDate(DateConverter.convert(request.checkInDate()));
            newRoom.setCheckOutDate(DateConverter.convert(request.checkOutDate()));
            newRoom.setRoomCapacity(room.getRoomCapacity());
            newRoom.setDailyPrice(room.getDailyPrice());
            newRoom.setHotel(room.getHotel());
            roomRepository.save(newRoom);
        }
    }
}
