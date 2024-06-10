package com.alican.hotelbookingsystem.repository;

import com.alican.hotelbookingsystem.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Long> {

    List<Location> findByCityContainsOrDistrictContains(String city, String district);
}
