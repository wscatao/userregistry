package com.paybridge.userregistry.presentation.controllers;

import com.paybridge.userregistry.application.usecases.UserUseCases;
import com.paybridge.userregistry.domain.entities.User;
import com.paybridge.userregistry.presentation.dtos.CreateUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/register")
public class UserController {

    private final UserUseCases userUseCases;

    public UserController(UserUseCases userUseCases) {
        this.userUseCases = userUseCases;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody CreateUserDTO createUserDTO) {

        User user = User.toUser(createUserDTO);
        userUseCases.registerUser(user);
        return ResponseEntity.ok().build();
    }
}
