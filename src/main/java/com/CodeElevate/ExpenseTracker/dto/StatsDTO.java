package com.CodeElevate.ExpenseTracker.dto;

import com.CodeElevate.ExpenseTracker.entity.Expense;
import com.CodeElevate.ExpenseTracker.entity.Income;
import lombok.Data;

@Data
public class StatsDTO {
    private Double income;
    private Double expense;
    private Income latestIncome;
    private Expense latestExpense;
}
