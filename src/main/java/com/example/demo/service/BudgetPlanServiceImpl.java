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
    public BudgetPlan create(BudgetPlan plan) {
        return repository.save(plan);
    }

    @Override
    public List<BudgetPlan> getAll() {
        return repository.findAll();
    }

    @Override
    public BudgetPlan getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("BudgetPlan not found"));
    }

    @Override
    public List<BudgetPlan> getByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public BudgetPlan getByUserAndMonthAndYear(Long userId, Integer month, Integer year) {
        return repository
                .findByUserIdAndMonthAndYear(userId, month, year)
                .orElseThrow(() -> new ResourceNotFoundException("BudgetPlan not found"));
    }
}
