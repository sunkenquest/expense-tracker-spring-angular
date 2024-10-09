package com.CodeElevate.ExpenseTracker.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class IncomeDTO {
    private Long id;

    private String title;

    private Integer amount;

    private LocalDateTime date;

    private String category;

    private String description;
}
