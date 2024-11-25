package com.paybridge.userregistry.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.paybridge.userregistry.infrastructure.rest.dto.AddressResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class Address {
    String street;
    String zipCode;
    String neighborhood;
    String city;
    String state;
    String uf;

    public static Address toAddress(AddressResponse addressResponse) {
        Address address = new Address();
        Optional.ofNullable(addressResponse.logradouro()).ifPresent(address::setStreet);
        Optional.ofNullable(addressResponse.cep()).ifPresent(address::setZipCode);
        Optional.ofNullable(addressResponse.bairro()).ifPresent(address::setNeighborhood);
        Optional.ofNullable(addressResponse.localidade()).ifPresent(address::setCity);
        Optional.ofNullable(addressResponse.estado()).ifPresent(address::setState);
        Optional.ofNullable(addressResponse.uf()).ifPresent(address::setUf);
        return address;
    }

    @JsonIgnore
    public boolean isEmpty() {
        return this.street == null;
    }
}
