package com.example.demo.service.impl;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.service.BudgetPlanService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository budgetPlanRepository;

    public BudgetPlanServiceImpl(BudgetPlanRepository budgetPlanRepository) {
        this.budgetPlanRepository = budgetPlanRepository;
    }

    @Override
    public BudgetPlan save(BudgetPlan budgetPlan) {
        return budgetPlanRepository.save(budgetPlan);
    }

    @Override
    public Optional<BudgetPlan> getByUserMonthYear(
            User user,
            Integer month,
            Integer year
    ) {
        return budgetPlanRepository.findByUserAndMonthAndYear(user, month, year);
    }
}
