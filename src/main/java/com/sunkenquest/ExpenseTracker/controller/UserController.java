package com.sunkenquest.ExpenseTracker.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sunkenquest.ExpenseTracker.dto.ResponseDTO;
import com.sunkenquest.ExpenseTracker.dto.UserLoginDTO;
import com.sunkenquest.ExpenseTracker.dto.UserRegisterDTO;
import com.sunkenquest.ExpenseTracker.entity.User;
import com.sunkenquest.ExpenseTracker.sevices.user.UserService;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserRegisterDTO dto) {
        User createdUser = userService.registerUser(dto);
        if (createdUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginDTO dto) {
        ResponseEntity<ResponseDTO> createdUser = userService.loginUser(dto);
        if (createdUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
