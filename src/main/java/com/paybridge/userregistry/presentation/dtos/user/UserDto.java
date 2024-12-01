package com.paybridge.userregistry.presentation.dtos.user;

import java.time.LocalDate;

public record UserDto(
        String name,
        String fullName,
        String email,
        String phone,
        String address,
        String city,
        String state,
        String zipCode,
        String country,
        String preferredCurrency,
        String preferredNotificationMethod,
        LocalDate birthDate
) {
}
