package com.example.demo.service.impl;

import com.example.demo.model.BudgetSummary;
import com.example.demo.repository.BudgetSummaryRepository;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository summaryRepository;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository summaryRepository) {
        this.summaryRepository = summaryRepository;
    }

    @Override
    public BudgetSummary getByUserId(Long userId) {
        return summaryRepository.findByUserId(userId);
    }

    @Override
    public BudgetSummary save(BudgetSummary summary) {
        return summaryRepository.save(summary);
    }
}
