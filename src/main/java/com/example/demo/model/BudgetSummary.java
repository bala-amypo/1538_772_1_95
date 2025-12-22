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

    // getters & setters
}
