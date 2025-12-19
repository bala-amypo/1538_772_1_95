package com.example.demo.repository;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BudgetPlanRepository
        extends JpaRepository<BudgetPlan, Long> {

    Optional<BudgetPlan> findByUser(User user);
}