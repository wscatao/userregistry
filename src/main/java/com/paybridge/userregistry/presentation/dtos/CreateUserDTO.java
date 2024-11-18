package com.paybridge.userregistry.presentation.dtos;

import java.time.LocalDate;

public record CreateUserDTO(
        String name,
        String fullName,
        String email,
        String password,
        String phone,
        String address,
        String city,
        String state,
        String zipCode,
        String country,
        String preferredCurrency,
        String preferredNotificationMethod,
        LocalDate birthDate) {
}
