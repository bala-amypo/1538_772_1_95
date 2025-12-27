package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "budget_summaries")
public class BudgetSummary {

    public static final String STATUS_UNDER_LIMIT = "UNDER_LIMIT";
    public static final String STATUS_OVER_LIMIT = "OVER_LIMIT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private BudgetPlan budgetPlan;

    private Double totalIncome;
    private Double totalExpense;
    private String status;
    private LocalDateTime generatedAt;

    public BudgetSummary() {}

    public BudgetSummary(Long id, BudgetPlan plan, Double income,
                         Double expense, String status, LocalDateTime time) {
        this.id = id;
        this.budgetPlan = plan;
        this.totalIncome = income;
        this.totalExpense = expense;
        this.status = status;
        this.generatedAt = time;
    }

    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    // getters/setters
    public void setBudgetPlan(BudgetPlan budgetPlan) { this.budgetPlan = budgetPlan; }
    public void setTotalIncome(Double totalIncome) { this.totalIncome = totalIncome; }
    public void setTotalExpense(Double totalExpense) { this.totalExpense = totalExpense; }
    public void setStatus(String status) { this.status = status; }
}
