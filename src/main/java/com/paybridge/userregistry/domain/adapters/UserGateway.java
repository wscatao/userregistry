package com.paybridge.userregistry.domain.adapters;

import com.paybridge.userregistry.domain.entities.User;

import java.util.Optional;

public interface UserGateway {
    void registerUser(User user);
    Optional<User> findUserById(Long userId);
}
