package com.paybridge.userregistry.application.usecases;

import com.paybridge.userregistry.domain.entities.User;

import java.util.Optional;

public interface UserUseCases {
    void registerUser(User user);
    User updateUser(User user);
    void deleteUser(User user);
    Optional<User> getUser(Long userId);
}
