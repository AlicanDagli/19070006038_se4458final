package com.alican.hotelbookingsystem.repository;

import com.alican.hotelbookingsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
