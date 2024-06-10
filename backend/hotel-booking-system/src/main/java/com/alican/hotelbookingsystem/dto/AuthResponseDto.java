package com.alican.hotelbookingsystem.dto;

import com.alican.hotelbookingsystem.model.Role;

public record AuthResponseDto(
    Long id,
    String token,
    Role role
) {
}
