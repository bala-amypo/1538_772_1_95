package com.example.demo.service;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;

import java.util.Optional;

public interface BudgetPlanService {

    BudgetPlan save(BudgetPlan budgetPlan);

    Optional<BudgetPlan> getByUserMonthYear(
            User user,
            Integer month,
            Integer year
    );
}
