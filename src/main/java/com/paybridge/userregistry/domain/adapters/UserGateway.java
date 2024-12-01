package com.paybridge.userregistry.domain.adapters;

import com.paybridge.userregistry.domain.entities.User;

import java.util.Optional;

public interface UserGateway {

    void saveUser(User user);

    Optional<User> findUserById(Long userId);

    Boolean updateUser(Long userId, User user);

    Boolean deleteUser(Long userId);
}
