package com.alican.hotelbookingsystem.service;

import com.alican.hotelbookingsystem.repository.BaseUserRepository;
import org.springframework.stereotype.Service;

@Service
public class BaseUserService {

    private final BaseUserRepository baseUserRepository;

    public BaseUserService(BaseUserRepository baseUserRepository) {
        this.baseUserRepository = baseUserRepository;
    }
}
