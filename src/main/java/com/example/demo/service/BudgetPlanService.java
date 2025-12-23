package com.example.demo.service;

import com.example.demo.model.BudgetPlan;

import java.util.List;

public interface BudgetPlanService {

    BudgetPlan save(BudgetPlan budgetPlan);

    List<BudgetPlan> getByUserId(Long userId);
}
