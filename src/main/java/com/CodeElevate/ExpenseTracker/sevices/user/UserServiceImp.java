package com.CodeElevate.ExpenseTracker.sevices.user;

import com.CodeElevate.ExpenseTracker.dto.UserDTO;
import com.CodeElevate.ExpenseTracker.entity.User;
import com.CodeElevate.ExpenseTracker.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User postUser(UserDTO userDTO) {
        return saveOrUpdateUser(new User(), userDTO);
    }

    private User saveOrUpdateUser(User user, UserDTO userDTO) {
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setBirthday(userDTO.getBirthday());
        user.setBio(userDTO.getBio());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setCreatedAt(LocalDate.now());

        return userRepository.save(user);
    }
}
