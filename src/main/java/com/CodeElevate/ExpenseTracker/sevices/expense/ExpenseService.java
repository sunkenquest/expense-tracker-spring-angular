package com.CodeElevate.ExpenseTracker.sevices.expense;

import com.CodeElevate.ExpenseTracker.dto.ExpenseDTO;
import com.CodeElevate.ExpenseTracker.entity.Expense;

import java.util.List;

public interface ExpenseService {

    Expense postExpense(ExpenseDTO expenseDTO);
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
}
