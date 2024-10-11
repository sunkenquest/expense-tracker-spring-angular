package com.CodeElevate.ExpenseTracker.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class IncomeDTO {
    private Long id;

    private String title;

    private Integer amount;

    private LocalDate date;

    private String category;

    private String description;
}
