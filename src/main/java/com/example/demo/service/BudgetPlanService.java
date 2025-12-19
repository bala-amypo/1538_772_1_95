package com.example.demo.service;

import com.example.demo.model.BudgetPlan;
import java.util.List;

public interface BudgetPlanService {
    BudgetPlan create(BudgetPlan plan);
    List<BudgetPlan> getAll();
}