package com.sunkenquest.ExpenseTracker.dto;

import lombok.Data;

import java.util.List;

import com.sunkenquest.ExpenseTracker.entity.Expense;
import com.sunkenquest.ExpenseTracker.entity.Income;

@Data
public class GraphDTO {

    private List<Expense> expenseList;

    private List<Income> incomeList;
}
