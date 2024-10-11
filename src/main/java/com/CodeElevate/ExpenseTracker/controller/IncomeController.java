package com.CodeElevate.ExpenseTracker.controller;

import com.CodeElevate.ExpenseTracker.dto.IncomeDTO;
import com.CodeElevate.ExpenseTracker.entity.Income;
import com.CodeElevate.ExpenseTracker.sevices.income.IncomeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
@CrossOrigin
public class IncomeController {
    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<?> postIncome(@RequestBody IncomeDTO incomeDto){
        Income createdIncome = incomeService.postIncome(incomeDto);
        if (createdIncome != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllIncomes(){
        return ResponseEntity.ok(incomeService.getAllIncomes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateIncome(@PathVariable Long id, @RequestBody IncomeDTO incomeDto){
        try {
            return ResponseEntity.ok(incomeService.updateIncome(id, incomeDto));
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
