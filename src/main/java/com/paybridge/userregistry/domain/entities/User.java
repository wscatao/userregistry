package com.paybridge.userregistry.domain.entities;

import com.paybridge.userregistry.infrastructure.database.model.UserModel;
import com.paybridge.userregistry.presentation.dtos.user.CreateUserDTO;
import com.paybridge.userregistry.presentation.dtos.user.UpdateUserDTO;
import com.paybridge.userregistry.presentation.dtos.user.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter
@Setter
public class User {
    private String name;
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String country;
    private String preferredCurrency;
    private String preferredNotificationMethod;
    private LocalDate birthDate;

    public static User fromCreateUserDTO(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setName(createUserDTO.name());
        user.setFullName(createUserDTO.fullName());
        user.setEmail(createUserDTO.email());
        user.setPassword(createUserDTO.password());
        user.setPhone(createUserDTO.phone());
        user.setAddress(createUserDTO.address());
        user.setCity(createUserDTO.city());
        user.setState(createUserDTO.state());
        user.setZipCode(createUserDTO.zipCode());
        user.setCountry(createUserDTO.country());
        user.setPreferredCurrency(createUserDTO.preferredCurrency());
        user.setPreferredNotificationMethod(createUserDTO.preferredNotificationMethod());
        user.setBirthDate(createUserDTO.birthDate());
        return user;
    }

    public static UserDto toUserDTO(User user) {
        return new UserDto(
                user.getName(),
                user.getFullName(),
                user.getEmail(),
                user.getPhone(),
                user.getAddress(),
                user.getCity(),
                user.getState(),
                user.getZipCode(),
                user.getCountry(),
                user.getPreferredCurrency(),
                user.getPreferredNotificationMethod(),
                user.getBirthDate()
        );
    }

    public static User fromUserModel(UserModel userModel) {
        User user = new User();
        user.setName(userModel.getName());
        user.setFullName(userModel.getFullName());
        user.setEmail(userModel.getEmail());
        user.setPhone(userModel.getPhone());
        user.setAddress(userModel.getAddress());
        user.setCity(userModel.getCity());
        user.setState(userModel.getState());
        user.setZipCode(userModel.getZipCode());
        user.setCountry(userModel.getCountry());
        user.setPreferredCurrency(userModel.getPreferredCurrency());
        user.setPreferredNotificationMethod(userModel.getPreferredNotificationMethod());
        user.setBirthDate(userModel.getBirthDate());
        return user;
    }

    public static User fromUpdateUserDTO(UpdateUserDTO updateUserDTO) {
        User user = new User();

        Optional.ofNullable(updateUserDTO.fullName()).ifPresent(user::setFullName);
        Optional.ofNullable(updateUserDTO.phone()).ifPresent(user::setPhone);
        Optional.ofNullable(updateUserDTO.address()).ifPresent(user::setAddress);
        Optional.ofNullable(updateUserDTO.city()).ifPresent(user::setCity);
        Optional.ofNullable(updateUserDTO.state()).ifPresent(user::setState);
        Optional.ofNullable(updateUserDTO.zipCode()).ifPresent(user::setZipCode);
        Optional.ofNullable(updateUserDTO.country()).ifPresent(user::setCountry);
        Optional.ofNullable(updateUserDTO.preferredCurrency()).ifPresent(user::setPreferredCurrency);
        Optional.ofNullable(updateUserDTO.preferredNotificationMethod()).ifPresent(user::setPreferredNotificationMethod);

        return user;
    }
}
