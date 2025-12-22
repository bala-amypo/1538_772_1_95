package com.example.demo.service;

import com.example.demo.model.BudgetPlan;
import java.util.List;

public interface BudgetPlanService {
    BudgetPlan save(BudgetPlan plan);
    List<BudgetPlan> getAll();
    BudgetPlan getById(Long id);
}
