package com.example.budget.service;

import com.example.budget.model.BudgetPlan;

public interface BudgetPlanService {
    BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan);
    BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year);
}
