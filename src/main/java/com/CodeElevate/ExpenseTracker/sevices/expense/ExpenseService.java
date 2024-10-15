package com.CodeElevate.ExpenseTracker.sevices.expense;

import com.CodeElevate.ExpenseTracker.dto.ExpenseDTO;
import com.CodeElevate.ExpenseTracker.entity.Expense;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ExpenseService {

    Expense postExpense(ExpenseDTO expenseDTO);

    Page<ExpenseDTO> getAllExpenses(Integer page);

    Expense getExpenseById(Long id);

    Expense updateExpense(Long id, ExpenseDTO expenseDTO);

    void deleteExpense(Long id);
}
