package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.BudgetSummaryService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BudgetSummaryServiceImpl implements BudgetSummaryService {

    private final BudgetSummaryRepository summaryRepo;
    private final BudgetPlanRepository planRepo;
    private final TransactionLogRepository transactionRepo;

    public BudgetSummaryServiceImpl(BudgetSummaryRepository summaryRepo,
                                    BudgetPlanRepository planRepo,
                                    TransactionLogRepository transactionRepo) {
        this.summaryRepo = summaryRepo;
        this.planRepo = planRepo;
        this.transactionRepo = transactionRepo;
    }

    @Override
    public BudgetSummary generateSummary(Long budgetPlanId) {
        BudgetPlan plan = planRepo.findById(budgetPlanId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Budget plan not found"));

        LocalDate start = LocalDate.of(plan.getYear(), plan.getMonth(), 1);
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        List<TransactionLog> logs =
                transactionRepo.findByUserAndTransactionDateBetween(
                        plan.getUser(), start, end);

        double income = 0;
        double expense = 0;

        for (TransactionLog log : logs) {
            if ("INCOME".equals(log.getCategory().getType())) {
                income += log.getAmount();
            } else {
                expense += log.getAmount();
            }
        }

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalIncome(income);
        summary.setTotalExpense(expense);

        summary.setStatus(
                expense <= plan.getExpenseLimit()
                        ? BudgetSummary.STATUS_UNDER_LIMIT
                        : BudgetSummary.STATUS_OVER_LIMIT
        );

        return summaryRepo.save(summary);
    }

    @Override
    public BudgetSummary getSummary(Long budgetPlanId) {
        BudgetPlan plan = planRepo.findById(budgetPlanId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Budget plan not found"));

        return summaryRepo.findByBudgetPlan(plan)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Summary not found"));
    }
}
