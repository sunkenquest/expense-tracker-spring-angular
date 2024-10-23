package com.sunkenquest.ExpenseTracker.sevices.income;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sunkenquest.ExpenseTracker.dto.IncomeDTO;
import com.sunkenquest.ExpenseTracker.entity.Income;
import com.sunkenquest.ExpenseTracker.repository.IncomeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImp implements IncomeService {

    private final IncomeRepository incomeRepository;

    public Income postIncome(IncomeDTO incomeDTO) {
        return saveOrUpdateIncome(new Income(), incomeDTO);
    }

    private Income saveOrUpdateIncome(Income income, IncomeDTO incomeDTO) {
        income.setTitle(incomeDTO.getTitle());
        income.setDate(incomeDTO.getDate());
        income.setAmount(incomeDTO.getAmount());
        income.setCategory(incomeDTO.getCategory());
        income.setDescription(incomeDTO.getDescription());

        return incomeRepository.save(income);
    }

    public Page<IncomeDTO> getAllIncomes(Integer page) {
        PageRequest pageable = PageRequest.of(page, 10);

        Page<Income> incomePage = incomeRepository.findAll(pageable);

        List<IncomeDTO> incomeDTOs = incomePage.getContent().stream()
                .map(Income::getIncomeDto)
                .collect(Collectors.toList());

        return new PageImpl<>(incomeDTOs, pageable, incomePage.getTotalElements());

    }

    public Income updateIncome(Long id, IncomeDTO incomeDTO) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);

        if (optionalIncome.isPresent()) {
            return saveOrUpdateIncome(optionalIncome.get(), incomeDTO);
        } else {
            throw new EntityNotFoundException("Income not found for id: " + id);
        }
    }

    public IncomeDTO getIncomeById(Long id) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);

        if (optionalIncome.isPresent()) {
            return optionalIncome.get().getIncomeDto();
        } else {
            throw new EntityNotFoundException("Income not found for id: " + id);
        }
    }

    public void deleteIncomeById(Long id) {
        Optional<Income> optionalIncome = incomeRepository.findById(id);
        if (optionalIncome.isPresent()) {
            incomeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Income not found for id: " + id);
        }
    }
}
