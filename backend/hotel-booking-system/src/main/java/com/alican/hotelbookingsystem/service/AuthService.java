package com.alican.hotelbookingsystem.service;

import com.alican.hotelbookingsystem.dto.AuthResponseDto;
import com.alican.hotelbookingsystem.dto.LoginRequest;
import com.alican.hotelbookingsystem.model.BaseUser;
import com.alican.hotelbookingsystem.repository.BaseUserRepository;
import com.alican.hotelbookingsystem.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final BaseUserRepository baseUserRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(BaseUserRepository baseUserRepository, AuthenticationManager authenticationManager, JwtService jwtService) {
        this.baseUserRepository = baseUserRepository;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public AuthResponseDto login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.email(), request.password()));
        if (authentication.isAuthenticated()) {
            String jwtToken = jwtService.generateToken(request.email());
            BaseUser user = baseUserRepository.findByEmail(request.email()).get();
            return new AuthResponseDto(user.getId(), jwtToken, user.getRole());
        }
        throw new RuntimeException("Invalid credentials");
    }
}
