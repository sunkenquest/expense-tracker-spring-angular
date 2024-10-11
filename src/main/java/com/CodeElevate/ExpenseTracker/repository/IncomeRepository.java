package com.CodeElevate.ExpenseTracker.repository;

import com.CodeElevate.ExpenseTracker.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
    List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);
}
