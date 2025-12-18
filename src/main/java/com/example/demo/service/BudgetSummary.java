package com.example.budget.service;

import com.example.budget.model.BudgetSummary;

public interface BudgetSummaryService {
    BudgetSummary generateSummary(Long budgetPlanId);
    BudgetSummary getSummary(Long budgetPlanId);
}
