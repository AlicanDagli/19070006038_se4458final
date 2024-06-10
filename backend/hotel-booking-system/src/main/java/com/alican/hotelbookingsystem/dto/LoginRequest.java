package com.alican.hotelbookingsystem.dto;

public record LoginRequest(
    String email,
    String password
) {
}
