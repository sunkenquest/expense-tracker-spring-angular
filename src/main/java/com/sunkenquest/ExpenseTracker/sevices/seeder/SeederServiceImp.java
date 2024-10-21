package com.sunkenquest.ExpenseTracker.sevices.seeder;

import com.github.javafaker.Faker;
import com.sunkenquest.ExpenseTracker.constants.Constants;
import com.sunkenquest.ExpenseTracker.entity.Expense;
import com.sunkenquest.ExpenseTracker.entity.Income;
import com.sunkenquest.ExpenseTracker.entity.User;
import com.sunkenquest.ExpenseTracker.repository.ExpenseRepository;
import com.sunkenquest.ExpenseTracker.repository.IncomeRepository;
import com.sunkenquest.ExpenseTracker.repository.UserRepository;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SeederServiceImp implements SeederService {
    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Random random = new Random();
    private final Faker faker = new Faker();

    public SeederServiceImp(
            ExpenseRepository expenseRepository,
            IncomeRepository incomeRepository,
            UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.expenseRepository = expenseRepository;
        this.incomeRepository = incomeRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void seedDatabase() {
        for (int i = 0; i < 10; i++) {
            Expense entity = new Expense();
            entity.setAmount(faker.number().numberBetween(0, 20000));
            entity.setTitle(faker.commerce().productName());
            entity.setDescription(faker.lorem().sentence());
            entity.setDate(LocalDate.now(ZoneId.of("Asia/Tokyo")));
            int randomIndex = random.nextInt(Constants.EXPENSE_CATEGORIES.length);
            entity.setCategory(Constants.EXPENSE_CATEGORIES[randomIndex]);
            expenseRepository.save(entity);
        }

        for (int i = 0; i < 10; i++) {
            Income entity = new Income();
            entity.setAmount(faker.number().numberBetween(0, 20000));
            entity.setTitle(faker.commerce().productName());
            entity.setDescription(faker.lorem().sentence());
            entity.setDate(LocalDate.now(ZoneId.of("Asia/Tokyo")));
            int randomIndex = random.nextInt(Constants.INCOME_CATEGORIES.length);
            entity.setCategory(Constants.INCOME_CATEGORIES[randomIndex]);
            incomeRepository.save(entity);
        }
        for (int i = 0; i < 1; i++) {
            User entity = new User();
            entity.setUsername(faker.name().username());
            entity.setEmail(faker.internet().emailAddress());
            entity.setPassword(passwordEncoder.encode("password"));
            entity.setPhoneNumber(faker.phoneNumber().phoneNumber());
            entity.setBirthday(faker.date().birthday().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
            entity.setBio(faker.backToTheFuture().quote());
            entity.setCreatedAt(faker.date().birthday().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
            entity.setLastLogin(faker.date().birthday().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate());
            userRepository.save(entity);
        }
    }
}