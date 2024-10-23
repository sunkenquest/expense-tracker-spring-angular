package com.sunkenquest.ExpenseTracker.command;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sunkenquest.ExpenseTracker.sevices.seeder.SeederService;

@Component
public class DBSeederCMDRunner implements CommandLineRunner {

    private final SeederService seederService;

    public DBSeederCMDRunner(SeederService seederService) {
        this.seederService = seederService;
    }

    @Override
    public void run(String... args) {
        seederService.seedDatabase();
    }
}
