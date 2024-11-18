package com.paybridge.userregistry.domain.entities;

import com.paybridge.userregistry.presentation.dtos.CreateUserDTO;
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

    public static User toUser(CreateUserDTO createUserDTO) {
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
}
