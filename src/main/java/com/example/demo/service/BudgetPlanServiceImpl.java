package com.example.budget.service.impl;

import com.example.budget.model.BudgetPlan;
import com.example.budget.repository.BudgetPlanRepository;
import com.example.budget.service.BudgetPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    @Autowired
    private BudgetPlanRepository budgetPlanRepository;

    @Override
    public BudgetPlan createBudgetPlan(Long userId, BudgetPlan plan) {
        plan.setUserId(userId);
        return budgetPlanRepository.save(plan);
    }

    @Override
    public BudgetPlan getBudgetPlan(Long userId, Integer month, Integer year) {
        return budgetPlanRepository.findByUserIdAndMonthAndYear(userId, month, year);
    }
}
