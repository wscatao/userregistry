package com.paybridge.userregistry.application.services;

import com.paybridge.userregistry.application.usecases.AddressUseCases;
import com.paybridge.userregistry.domain.adapters.AddressGateway;
import com.paybridge.userregistry.domain.entities.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements AddressUseCases {

    private final AddressGateway addressGateway;

    public AddressService(AddressGateway addressGateway) {
        this.addressGateway = addressGateway;
    }

    @Override
    public Address findAddress(String zipCode) {
        return addressGateway.findAddress(zipCode);
    }
}
