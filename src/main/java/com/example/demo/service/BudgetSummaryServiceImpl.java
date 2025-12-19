package com.example.demo.service.impl;

import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository budgetSummaryRepository;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository budgetSummaryRepository) {
        this.budgetSummaryRepository = budgetSummaryRepository;
    }

    @Override
    public BudgetSummary save(BudgetSummary budgetSummary) {
        return budgetSummaryRepository.save(budgetSummary);
    }
}
