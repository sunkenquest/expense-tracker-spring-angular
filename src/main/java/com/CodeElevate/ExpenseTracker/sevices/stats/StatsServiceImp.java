package com.CodeElevate.ExpenseTracker.sevices.stats;

import com.CodeElevate.ExpenseTracker.dto.GraphDTO;
import com.CodeElevate.ExpenseTracker.dto.StatsDTO;
import com.CodeElevate.ExpenseTracker.entity.Expense;
import com.CodeElevate.ExpenseTracker.entity.Income;
import com.CodeElevate.ExpenseTracker.repository.ExpenseRepository;
import com.CodeElevate.ExpenseTracker.repository.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StatsServiceImp implements StatsService {
    private final IncomeRepository incomeRepository;
    private final ExpenseRepository expenseRepository;

    public GraphDTO getChartData(){
        LocalDate endDate = LocalDate.now();
        LocalDate startDate = endDate.minusDays(27);

        GraphDTO graphDTO = new GraphDTO();
        graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate, endDate));
        graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate, endDate));

        return graphDTO;
    }

    public StatsDTO getStats(){
        Double totalIncome = incomeRepository.sumAllAmounts();
        Double totalExpense = expenseRepository.sumAllAmounts();

        Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();
        Optional<Expense> optionalExpense = expenseRepository.findFirstByOrderByDateDesc();

        StatsDTO statsDTO = new StatsDTO();
        statsDTO.setExpense(totalExpense);
        statsDTO.setIncome(totalIncome);

        optionalIncome.ifPresent(statsDTO::setLatestIncome);
        optionalExpense.ifPresent(statsDTO::setLatestExpense);

        return statsDTO;
    }
}
