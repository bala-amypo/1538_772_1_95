package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class BudgetSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double totalSpent;

    @OneToOne
    private User user;

    public Long getId() {
        return id;
    }

    public double getTotalSpent() {
        return totalSpent;
    }

    public User getUser() {
        return user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotalSpent(double totalSpent) {
        this.totalSpent = totalSpent;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
