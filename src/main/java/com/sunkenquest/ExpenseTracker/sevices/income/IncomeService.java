package com.sunkenquest.ExpenseTracker.sevices.income;

import org.springframework.data.domain.Page;

import com.sunkenquest.ExpenseTracker.dto.IncomeDTO;
import com.sunkenquest.ExpenseTracker.entity.Income;

public interface IncomeService {
    Income postIncome(IncomeDTO incomeDTO);

    Page<IncomeDTO> getAllIncomes(Integer page);

    Income updateIncome(Long id, IncomeDTO incomeDTO);

    IncomeDTO getIncomeById(Long id);

    void deleteIncomeById(Long id);
}
