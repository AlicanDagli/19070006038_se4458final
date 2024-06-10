package com.alican.hotelbookingsystem.repository;

import com.alican.hotelbookingsystem.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseUserRepository extends JpaRepository<BaseUser, Long> {

    Optional<BaseUser> findByEmail(String email);
}
