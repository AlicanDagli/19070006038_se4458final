package com.alican.hotelbookingsystem;

import com.alican.hotelbookingsystem.model.Admin;
import com.alican.hotelbookingsystem.model.Customer;
import com.alican.hotelbookingsystem.model.Role;
import com.alican.hotelbookingsystem.repository.AdminRepository;
import com.alican.hotelbookingsystem.repository.CustomerRepository;
import com.alican.hotelbookingsystem.service.AdminService;
import com.alican.hotelbookingsystem.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class HotelBookingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingSystemApplication.class, args);
	}

}
