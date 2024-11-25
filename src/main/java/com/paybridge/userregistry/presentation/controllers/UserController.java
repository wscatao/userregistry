package com.paybridge.userregistry.presentation.controllers;

import com.paybridge.userregistry.application.usecases.UserUseCases;
import com.paybridge.userregistry.domain.entities.User;
import com.paybridge.userregistry.presentation.dtos.user.CreateUserDTO;
import com.paybridge.userregistry.presentation.dtos.user.UpdateUserDTO;
import com.paybridge.userregistry.presentation.dtos.user.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserUseCases userUseCases;

    public UserController(UserUseCases userUseCases) {
        this.userUseCases = userUseCases;
    }

    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody CreateUserDTO createUserDTO) {

        User user = User.fromCreateUserDTO(createUserDTO);
        userUseCases.registerUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {

        Optional<User> userById = userUseCases.getUser(userId);
        if (userById.isPresent()) {
            User user = userById.get();
            UserDto userDTO = User.toUserDTO(user);
            return ResponseEntity.ok().body(userDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(
            @PathVariable Long userId,
            @RequestBody UpdateUserDTO updateUserDTO) {

        User user = User.fromUpdateUserDTO(updateUserDTO);
        Boolean userUpdated = userUseCases.updateUser(userId, user);
        if (Boolean.TRUE.equals(userUpdated)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        Boolean userDeleted = userUseCases.deleteUser(userId);
        if(Boolean.TRUE.equals(userDeleted)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
