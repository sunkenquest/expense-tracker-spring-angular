package com.sunkenquest.ExpenseTracker.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.sunkenquest.ExpenseTracker.dto.IncomeDTO;

@Entity
@Data
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Integer amount;

    private LocalDate date;

    private String category;

    private String description;

    public IncomeDTO getIncomeDto() {
        IncomeDTO incomeDTO = new IncomeDTO();

        incomeDTO.setId(id);
        incomeDTO.setTitle(title);
        incomeDTO.setAmount(amount);
        incomeDTO.setDate(date);
        incomeDTO.setCategory(category);
        incomeDTO.setDescription(description);

        return incomeDTO;
    }
}
