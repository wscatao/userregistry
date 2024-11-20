package com.paybridge.userregistry.infrastructure.database.repositories;

import com.paybridge.userregistry.domain.adapters.UserGateway;
import com.paybridge.userregistry.domain.entities.User;
import com.paybridge.userregistry.infrastructure.database.datasources.UserRepositoryDatasource;
import com.paybridge.userregistry.infrastructure.database.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserGatewayImpl implements UserGateway {

    private final UserRepositoryDatasource userRepositoryDatasource;

    public UserGatewayImpl(UserRepositoryDatasource userRepositoryDatasource) {
        this.userRepositoryDatasource = userRepositoryDatasource;
    }

    @Override
    public void registerUser(User user) {
        UserModel userModel = UserModel.toUserModel(user);
        userRepositoryDatasource.save(userModel);
    }

    @Override
    public Optional<User> findUserById(Long userId) {
        Optional<UserModel> userModelById = userRepositoryDatasource.findById(userId);
        if(userModelById.isPresent()) {
            User user = User.fromUserModel(userModelById.get());
            return Optional.of(user);
        } else {
            return Optional.empty();
        }
    }
}
