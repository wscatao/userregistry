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
        userGateway.saveUser(user);
    }

    @Override
    public Boolean updateUser(Long userId, User user) {
        return userGateway.updateUser(userId, user);
    }

    @Override
    public Boolean deleteUser(Long userId) {
        return userGateway.deleteUser(userId);
    }

    @Override
    public Optional<User> getUser(Long userId) {
        return userGateway.findUserById(userId);
    }
}
