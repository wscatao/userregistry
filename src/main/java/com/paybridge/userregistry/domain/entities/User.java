package com.paybridge.userregistry.domain.entities;

import com.paybridge.userregistry.infrastructure.database.model.UserModel;
import com.paybridge.userregistry.presentation.dtos.CreateUserDTO;
import com.paybridge.userregistry.presentation.dtos.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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
}
