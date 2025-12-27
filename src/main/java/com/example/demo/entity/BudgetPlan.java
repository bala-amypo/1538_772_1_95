package com.example.demo.model;

import com.example.demo.exception.BadRequestException;
import jakarta.persistence.*;

@Entity
@Table(name = "budget_plans")
public class BudgetPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private Integer month;
    private Integer year;
    private Double incomeTarget;
    private Double expenseLimit;

    public BudgetPlan() {}

    public BudgetPlan(Long id, User user, Integer month, Integer year,
                      Double incomeTarget, Double expenseLimit) {
        this.id = id;
        this.user = user;
        this.month = month;
        this.year = year;
        this.incomeTarget = incomeTarget;
        this.expenseLimit = expenseLimit;
    }

    public void validate() {
        if (month < 1 || month > 12) {
            throw new BadRequestException("Invalid month");
        }
        if (incomeTarget < 0 || expenseLimit < 0) {
            throw new BadRequestException("Amounts must be >= 0");
        }
    }

    // getters/setters
    public void setUser(User user) { this.user = user; }
    public User getUser() { return user; }
    public Integer getMonth() { return month; }
    public Integer getYear() { return year; }
    public Double getExpenseLimit() { return expenseLimit; }
}
