package com.paybridge.userregistry.application.usecases;

import com.paybridge.userregistry.domain.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserUseCases {
    void registerUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
    Optional<User> getUser(String email, String password);
}
