package com.CodeElevate.ExpenseTracker.sevices.seeder;

import com.CodeElevate.ExpenseTracker.constants.Constants;
import com.CodeElevate.ExpenseTracker.entity.Expense;
import com.CodeElevate.ExpenseTracker.entity.Income;
import com.CodeElevate.ExpenseTracker.repository.ExpenseRepository;
import com.CodeElevate.ExpenseTracker.repository.IncomeRepository;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class SeederServiceImp implements SeederService {
    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;

    private final Random random = new Random();
    private final Faker faker = new Faker();

    public SeederServiceImp(ExpenseRepository expenseRepository, IncomeRepository incomeRepository) {
        this.expenseRepository = expenseRepository;
        this.incomeRepository = incomeRepository;
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
    }
}