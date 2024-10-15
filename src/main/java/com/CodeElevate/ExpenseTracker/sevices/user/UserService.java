package com.CodeElevate.ExpenseTracker.sevices.user;

import org.springframework.http.ResponseEntity;

import com.CodeElevate.ExpenseTracker.dto.ResponseDTO;
import com.CodeElevate.ExpenseTracker.dto.UserLoginDTO;
import com.CodeElevate.ExpenseTracker.dto.UserRegisterDTO;
import com.CodeElevate.ExpenseTracker.entity.User;

public interface UserService {
    User registerUser(UserRegisterDTO userDTO);

    ResponseEntity<ResponseDTO> loginUser(UserLoginDTO userDTO);
}
