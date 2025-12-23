package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.service.BudgetPlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository repository;

    public BudgetPlanServiceImpl(BudgetPlanRepository repository) {
        this.repository = repository;
    }

    @Override
    public BudgetPlan save(BudgetPlan budgetPlan) {
        return repository.save(budgetPlan);
    }

    @Override
    public List<BudgetPlan> getByUserId(Long userId) {
        List<BudgetPlan> plans = repository.findByUserId(userId);
        if (plans.isEmpty()) {
            throw new ResourceNotFoundException("No budget plans found");
        }
        return plans;
    }
}
