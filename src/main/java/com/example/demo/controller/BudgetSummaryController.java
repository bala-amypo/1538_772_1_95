package com.example.demo.controller;

import com.example.demo.model.BudgetSummary;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/summary")
public class BudgetSummaryController {

    private final BudgetSummaryService service;

    public BudgetSummaryController(BudgetSummaryService service) {
        this.service = service;
    }

    @PostMapping("/generate/{budgetPlanId}")
    public BudgetSummary generate(@PathVariable Long budgetPlanId) {
        return service.generateSummary(budgetPlanId);
    }

    @GetMapping("/{budgetPlanId}")
    public BudgetSummary get(@PathVariable Long budgetPlanId) {
        return service.getSummary(budgetPlanId);
    }
}
