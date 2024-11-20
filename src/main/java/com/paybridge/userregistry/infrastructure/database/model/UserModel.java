package com.paybridge.userregistry.infrastructure.database.model;

import com.paybridge.userregistry.domain.entities.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserModel {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "country")
    private String country;

    @Column(name = "preferred_currency")
    private String preferredCurrency;

    @Column(name = "preferred_notification_method")
    private String preferredNotificationMethod;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    public static UserModel toUserModel(User user) {
        UserModel userModel = new UserModel();
        userModel.setName(user.getName());
        userModel.setFullName(user.getFullName());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(user.getPassword());
        userModel.setPhone(user.getPhone());
        userModel.setAddress(user.getAddress());
        userModel.setCity(user.getCity());
        userModel.setState(user.getState());
        userModel.setZipCode(user.getZipCode());
        userModel.setCountry(user.getCountry());
        userModel.setPreferredCurrency(user.getPreferredCurrency());
        userModel.setPreferredNotificationMethod(user.getPreferredNotificationMethod());
        userModel.setBirthDate(user.getBirthDate());
        return userModel;
    }
}
