package com.example.demo.service;

import com.example.demo.model.BudgetSummary;

public interface BudgetSummaryService {
    BudgetSummary getByUserId(Long userId);
    BudgetSummary save(BudgetSummary summary);
}
