package com.paybridge.userregistry.domain.adapters;

import com.paybridge.userregistry.domain.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserGateway {
    void registerUser(User user);
    Optional<User> findUserByEmailAndPassword(String email, String password);
}
