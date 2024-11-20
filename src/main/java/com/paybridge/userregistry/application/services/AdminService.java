package com.paybridge.userregistry.application.services;

import com.paybridge.userregistry.application.usecases.AdminUseCases;
import com.paybridge.userregistry.domain.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminService implements AdminUseCases {

    @Override
    public List<User> getAllUsers() {
        return List.of();
    }

    @Override
    public void resetUserPassword(UUID userId, String password) {

    }
}
