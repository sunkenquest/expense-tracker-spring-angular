package com.CodeElevate.ExpenseTracker.command;

import com.CodeElevate.ExpenseTracker.sevices.seeder.SeederService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBSeederCMDRunner implements CommandLineRunner {

    private final SeederService seederService;

    public DBSeederCMDRunner(SeederService seederService) {
        this.seederService = seederService;
    }

    @Override
    public void run(String... args) {
        if (args.length > 0 && "seed".equals(args[0])) {
            seederService.seedDatabase();
            System.out.println("Database has been seeded.");
        } else {
            System.out.println("Skipping database seeding.");
        }
    }
}
