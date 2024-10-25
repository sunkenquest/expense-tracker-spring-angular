package com.CodeElevate.ExpenseTracker.sevices.expense;

import com.CodeElevate.ExpenseTracker.dto.ExpenseDTO;
import com.CodeElevate.ExpenseTracker.entity.Expense;
import com.CodeElevate.ExpenseTracker.repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public Expense postExpense(ExpenseDTO expenseDTO) {
        return saveOrUpdateExpense(new Expense(), expenseDTO);
    }

    private Expense saveOrUpdateExpense(Expense expense, ExpenseDTO expenseDTO) {
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());

        return expenseRepository.save(expense);
    }

    public Page<ExpenseDTO> getAllExpenses(Integer page, String sortType) {
        Sort sort = Sort.by("title");

        switch (sortType.toLowerCase()) {
            case "desc":
                sort = Sort.by(Sort.Direction.DESC, "title");
                break;
            case "asc":
                sort = Sort.by(Sort.Direction.ASC, "title");
                break;
            case "tohigher":
                sort = Sort.by(Sort.Direction.ASC, "amount");
                break;
            case "tolower":
                sort = Sort.by(Sort.Direction.DESC, "amount");
                break;
            default:
                sort = Sort.by(Sort.Direction.ASC, "title");
                break;
        }

        PageRequest pageable = PageRequest.of(page, 10, sort);

        Page<Expense> expensPage = expenseRepository.findAll(pageable);

        List<ExpenseDTO> expenseDTOs = expensPage.getContent().stream()
                .map(Expense::getExpenseDto)
                .collect(Collectors.toList());

        return new PageImpl<>(expenseDTOs, pageable, expensPage.getTotalElements());
    }

    public Expense getExpenseById(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);

        if (optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            throw new EntityNotFoundException("Expense not found for id: " + id);
        }
    }

    public Expense updateExpense(Long id, ExpenseDTO expenseDTO) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);

        if (optionalExpense.isPresent()) {
            return saveOrUpdateExpense(optionalExpense.get(), expenseDTO);
        } else {
            throw new EntityNotFoundException("Expense not found for id: " + id);
        }
    }

    public void deleteExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            expenseRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Expense not found for id: " + id);
        }
    }
}
