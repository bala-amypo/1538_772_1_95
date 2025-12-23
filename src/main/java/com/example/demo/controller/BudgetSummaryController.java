package com.example.demo.controller;

import com.example.demo.model.BudgetSummary;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/budget-summary")
public class BudgetSummaryController {

    private final BudgetSummaryService service;

    public BudgetSummaryController(BudgetSummaryService service) {
        this.service = service;
    }

    @GetMapping("/{userId}")
    public BudgetSummary getSummary(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }

    @PostMapping
    public BudgetSummary createSummary(@RequestBody BudgetSummary budgetSummary) {
        return service.save(budgetSummary);
    }
}
