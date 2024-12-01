package com.paybridge.userregistry.domain.adapters;

import com.paybridge.userregistry.domain.entities.Address;

public interface AddressGateway {
    Address findAddress(String zipCode);
}
