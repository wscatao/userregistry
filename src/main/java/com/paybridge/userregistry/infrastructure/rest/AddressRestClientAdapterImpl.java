package com.paybridge.userregistry.infrastructure.rest;

import com.paybridge.userregistry.domain.adapters.AddressGateway;
import com.paybridge.userregistry.domain.entities.Address;
import com.paybridge.userregistry.infrastructure.rest.dto.AddressResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class AddressRestClientAdapterImpl implements AddressGateway {
    @Override
    public Address findAddress(String zipCode) {

        RestClient restClient = RestClient.create();

        AddressResponse addressResponse = restClient
                .method(HttpMethod.GET)
                .uri("http://viacep.com.br/ws/{zipCode}/json/", zipCode)
                .retrieve()
                .body(AddressResponse.class);

        if(addressResponse == null) {
            return new Address();
        }
        return Address.toAddress(addressResponse);
    }
}
