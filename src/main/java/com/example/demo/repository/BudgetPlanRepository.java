package com.example.demo.repository;

import com.example.demo.model.BudgetPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetPlanRepository extends JpaRepository<BudgetPlan, Long> {
}
