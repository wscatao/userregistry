package com.paybridge.userregistry.presentation.dtos;

public record UpdateUserDTO(
        String fullName,
        String phone,
        String address,
        String city,
        String state,
        String zipCode,
        String country,
        String preferredCurrency,
        String preferredNotificationMethod
) {
}
