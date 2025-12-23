package com.example.demo.service;

import com.example.demo.model.BudgetPlan;

import java.util.List;

public interface BudgetPlanService {

    BudgetPlan create(BudgetPlan plan);

    List<BudgetPlan> getAll();

    BudgetPlan getById(Long id);

    List<BudgetPlan> getByUserId(Long userId);

    BudgetPlan getByUserAndMonthAndYear(Long userId, Integer month, Integer year);
}
