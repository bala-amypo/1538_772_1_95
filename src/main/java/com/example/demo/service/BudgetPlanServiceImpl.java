package com.example.demo.service.impl;

import com.example.demo.exception.BadRequestException;
import com.example.demo.model.BudgetPlan;
import com.example.demo.repository.BudgetPlanRepository;
import com.example.demo.service.BudgetPlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetPlanServiceImpl implements BudgetPlanService {

    private final BudgetPlanRepository budgetPlanRepository;

    public BudgetPlanServiceImpl(BudgetPlanRepository budgetPlanRepository) {
        this.budgetPlanRepository = budgetPlanRepository;
    }

    @Override
    public BudgetPlan save(BudgetPlan plan) {
        if (plan.getLimitAmount() <= 0) {
            throw new BadRequestException("Limit amount must be greater than zero");
        }
        return budgetPlanRepository.save(plan);
    }

    @Override
    public List<BudgetPlan> getAll() {
        return budgetPlanRepository.findAll();
    }

    @Override
    public BudgetPlan getById(Long id) {
        return budgetPlanRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Budget plan not found"));
    }
}
