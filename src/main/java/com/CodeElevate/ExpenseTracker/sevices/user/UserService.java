package com.CodeElevate.ExpenseTracker.sevices.user;

import com.CodeElevate.ExpenseTracker.dto.ExpenseDTO;
import com.CodeElevate.ExpenseTracker.dto.UserDTO;
import com.CodeElevate.ExpenseTracker.entity.Expense;
import com.CodeElevate.ExpenseTracker.entity.User;

public interface UserService {
    User postUser(UserDTO userDTO);

}
