package com.alican.hotelbookingsystem.repository;

import com.alican.hotelbookingsystem.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
