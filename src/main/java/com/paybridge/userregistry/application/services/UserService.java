package com.paybridge.userregistry.application.services;

import com.paybridge.userregistry.application.usecases.UserUseCases;
import com.paybridge.userregistry.domain.adapters.UserGateway;
import com.paybridge.userregistry.domain.entities.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserUseCases {

    private final UserGateway userGateway;

    public UserService(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public void registerUser(User user) {
        userGateway.registerUser(user);
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(User user) {
        /**
         * To be implemented
         */
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return userGateway.findUserById(userId);
    }
}
