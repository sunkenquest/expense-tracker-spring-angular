package com.CodeElevate.ExpenseTracker.entity;

import java.time.LocalDate;

import com.CodeElevate.ExpenseTracker.dto.UserRegisterDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate birthday;
    private String bio;
    private LocalDate createdAt;

    public UserRegisterDTO geUserDto() {
        UserRegisterDTO userDTO = new UserRegisterDTO();

        userDTO.setId(id);
        userDTO.setUsername(username);
        userDTO.setEmail(email);
        userDTO.setPassword(password);
        userDTO.setPhoneNumber(phoneNumber);
        userDTO.setBirthday(birthday);
        userDTO.setBio(bio);
        userDTO.setCreatedAt(createdAt);
        return userDTO;
    }
}
