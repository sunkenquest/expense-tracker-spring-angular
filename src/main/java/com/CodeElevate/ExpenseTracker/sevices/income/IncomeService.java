package com.CodeElevate.ExpenseTracker.sevices.income;

import com.CodeElevate.ExpenseTracker.dto.IncomeDTO;
import com.CodeElevate.ExpenseTracker.entity.Income;

public interface IncomeService {
    Income postIncome(IncomeDTO incomeDTO);
}
