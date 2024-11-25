package com.paybridge.userregistry.presentation.controllers;

import com.paybridge.userregistry.application.usecases.AddressUseCases;
import com.paybridge.userregistry.domain.entities.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class ZipCodeController {

    private final AddressUseCases addressUseCases;

    public ZipCodeController(AddressUseCases addressUseCases) {
        this.addressUseCases = addressUseCases;
    }

    @GetMapping("/{zipCode}")
    public ResponseEntity<Address> findAddress(@PathVariable String zipCode) {
        Address address = addressUseCases.findAddress(zipCode);
        if(address.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(address);
    }
}
