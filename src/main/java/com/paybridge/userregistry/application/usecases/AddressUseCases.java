package com.paybridge.userregistry.application.usecases;

import com.paybridge.userregistry.domain.entities.Address;

public interface AddressUseCases {
    Address findAddress(String zipCode);
}
