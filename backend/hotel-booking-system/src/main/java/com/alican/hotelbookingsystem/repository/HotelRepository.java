package com.alican.hotelbookingsystem.repository;

import com.alican.hotelbookingsystem.model.Hotel;
import com.alican.hotelbookingsystem.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
