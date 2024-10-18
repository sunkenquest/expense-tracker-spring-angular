package com.CodeElevate.ExpenseTracker.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UserRegisterDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private LocalDate birthday;
    private String bio;
    private LocalDate createdAt;
    private LocalDate lastLogin;
}
