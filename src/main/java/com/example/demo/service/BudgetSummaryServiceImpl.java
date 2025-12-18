package com.example.budget.service.impl;

import com.example.budget.model.BudgetSummary;
import com.example.budget.repository.BudgetSummaryRepository;
import com.example.budget.service.BudgetSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    @Autowired
    private BudgetSummaryRepository budgetSummaryRepository;

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {
        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlanId(budgetPlanId);
        return budgetSummaryRepository.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {
        return budgetSummaryRepository.findByBudgetPlanId(budgetPlanId);
    }
}
