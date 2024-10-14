package com.sunkenquest.ExpenseTracker.sevices.income;

import java.util.List;

import com.sunkenquest.ExpenseTracker.dto.IncomeDTO;
import com.sunkenquest.ExpenseTracker.entity.Income;

public interface IncomeService {
    Income postIncome(IncomeDTO incomeDTO);

    List<IncomeDTO> getAllIncomes();

    Income updateIncome(Long id, IncomeDTO incomeDTO);

    IncomeDTO getIncomeById(Long id);

    void deleteIncomeById(Long id);
}
