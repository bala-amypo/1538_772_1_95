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


@OneToOne(optional = false)
private BudgetPlan budgetPlan;


private Double totalIncome;
private Double totalExpense;
private String status;
private LocalDateTime generatedAt;


public BudgetSummary() {}


public BudgetSummary(Long id, BudgetPlan budgetPlan, Double totalIncome,
Double totalExpense, String status, LocalDateTime generatedAt) {
this.id = id;
this.budgetPlan = budgetPlan;
this.totalIncome = totalIncome;
this.totalExpense = totalExpense;
this.status = status;
this.generatedAt = generatedAt;
}


@PrePersist
public void onCreate() {
this.generatedAt = LocalDateTime.now();
}


public Long getId() { return id; }
public BudgetPlan getBudgetPlan() { return budgetPlan; }
public Double getTotalIncome() { return totalIncome; }
public Double getTotalExpense() { return totalExpense; }
public String getStatus() { return status; }
public LocalDateTime getGeneratedAt() { return generatedAt; }
}