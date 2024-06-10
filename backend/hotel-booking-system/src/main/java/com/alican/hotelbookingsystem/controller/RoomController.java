package com.alican.hotelbookingsystem.controller;

import com.alican.hotelbookingsystem.dto.BookingRoomRequest;
import com.alican.hotelbookingsystem.dto.RoomDto;
import com.alican.hotelbookingsystem.dto.SaveRoomRequest;
import com.alican.hotelbookingsystem.dto.SearchRoomRequest;
import com.alican.hotelbookingsystem.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public ResponseEntity<List<RoomDto>> getRooms() {
        return ResponseEntity.ok(roomService.getRooms());
    }

    @PostMapping
    public ResponseEntity<Void> saveRoom(@RequestBody SaveRoomRequest request) {
        roomService.saveRoom(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/booking")
    public void bookingRoom(@RequestBody BookingRoomRequest request) {
        roomService.bookingRoom(request);
    }

    @PostMapping("/find")
    public ResponseEntity<List<RoomDto>> findRooms(@RequestBody SearchRoomRequest request) {
        return ResponseEntity.ok(roomService.findRooms(request));
    }
}
