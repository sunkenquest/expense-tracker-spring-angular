package com.CodeElevate.ExpenseTracker.sevices.user;

import com.CodeElevate.ExpenseTracker.dto.ResponseDTO;
import com.CodeElevate.ExpenseTracker.dto.UserLoginDTO;
import com.CodeElevate.ExpenseTracker.dto.UserRegisterDTO;
import com.CodeElevate.ExpenseTracker.entity.User;
import com.CodeElevate.ExpenseTracker.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public User registerUser(UserRegisterDTO userDTO) {
        Optional<User> optionalUsername = userRepository.findByUsername(userDTO.getUsername());
        Optional<User> optionalEmail = userRepository.findByEmail(userDTO.getEmail());

        if (optionalUsername.isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        if (optionalEmail.isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        return saveOrUpdateUser(new User(), userDTO);
    }

    private User saveOrUpdateUser(User user, UserRegisterDTO userDTO) {
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setBirthday(userDTO.getBirthday());
        user.setBio(userDTO.getBio());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setCreatedAt(LocalDate.now());
        user.setLastLogin(LocalDate.now());

        return userRepository.save(user);
    }

    public ResponseEntity<ResponseDTO> loginUser(UserLoginDTO loginUserDTO) {
        Optional<User> optionalUser = userRepository.findByUsername(loginUserDTO.getUsername());

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(loginUserDTO.getPassword(), user.getPassword())) {
                user.setRemember(loginUserDTO.isRemember());
                userRepository.save(user);
                ResponseDTO response = new ResponseDTO("Login successful");
                return ResponseEntity.ok(response);

            } else {
                throw new IllegalArgumentException("Invalid password");
            }
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }
}
