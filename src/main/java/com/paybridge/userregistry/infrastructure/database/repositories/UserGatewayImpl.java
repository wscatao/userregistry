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
    public void saveUser(User user) {
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

    @Override
    public Boolean updateUser(Long userId, User user) {
        Optional<UserModel> userModelById = userRepositoryDatasource.findById(userId);
        if(userModelById.isPresent()) {
            UserModel userModel = userModelById.get();
            Optional.ofNullable(user.getFullName()).ifPresent(userModel::setFullName);
            Optional.ofNullable(user.getPhone()).ifPresent(userModel::setPhone);
            Optional.ofNullable(user.getAddress()).ifPresent(userModel::setAddress);
            Optional.ofNullable(user.getCity()).ifPresent(userModel::setCity);
            Optional.ofNullable(user.getState()).ifPresent(userModel::setState);
            Optional.ofNullable(user.getZipCode()).ifPresent(userModel::setZipCode);
            Optional.ofNullable(user.getCountry()).ifPresent(userModel::setCountry);
            Optional.ofNullable(user.getPreferredCurrency()).ifPresent(userModel::setPreferredCurrency);
            Optional.ofNullable(user.getPreferredNotificationMethod()).ifPresent(userModel::setPreferredNotificationMethod);
            userRepositoryDatasource.save(userModel);
            return true;
        } else {
            return false;
        }
    }
}
