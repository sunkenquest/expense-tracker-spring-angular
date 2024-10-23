package com.sunkenquest.ExpenseTracker.sevices.user;

import org.springframework.http.ResponseEntity;

import com.sunkenquest.ExpenseTracker.dto.ResponseDTO;
import com.sunkenquest.ExpenseTracker.dto.UserLoginDTO;
import com.sunkenquest.ExpenseTracker.dto.UserRegisterDTO;
import com.sunkenquest.ExpenseTracker.entity.User;

public interface UserService {
    User registerUser(UserRegisterDTO userDTO);

    ResponseEntity<ResponseDTO> loginUser(UserLoginDTO userDTO);
}
