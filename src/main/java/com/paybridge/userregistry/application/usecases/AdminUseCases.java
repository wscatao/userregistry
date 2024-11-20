package com.paybridge.userregistry.application.usecases;

import com.paybridge.userregistry.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface AdminUseCases {
    List<User> getAllUsers();
    void resetUserPassword(UUID userId, String password);
}
