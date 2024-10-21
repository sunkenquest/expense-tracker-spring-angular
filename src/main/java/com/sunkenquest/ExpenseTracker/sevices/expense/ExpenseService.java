package com.sunkenquest.ExpenseTracker.sevices.expense;

import org.springframework.data.domain.Page;

import com.sunkenquest.ExpenseTracker.dto.ExpenseDTO;
import com.sunkenquest.ExpenseTracker.entity.Expense;

public interface ExpenseService {

    Expense postExpense(ExpenseDTO expenseDTO);

    Page<ExpenseDTO> getAllExpenses(Integer page);

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
}
