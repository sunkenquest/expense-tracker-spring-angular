package com.sunkenquest.ExpenseTracker.sevices.expense;

import java.util.List;

import com.sunkenquest.ExpenseTracker.dto.ExpenseDTO;
import com.sunkenquest.ExpenseTracker.entity.Expense;

public interface ExpenseService {

    Expense postExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
}
