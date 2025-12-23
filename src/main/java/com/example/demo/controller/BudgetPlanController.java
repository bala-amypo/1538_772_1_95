package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.service.BudgetPlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget-plans")
public class BudgetPlanController {

    private final BudgetPlanService service;

    public BudgetPlanController(BudgetPlanService service) {
        this.service = service;
    }

    @PostMapping
    public BudgetPlan save(@RequestBody BudgetPlan plan) {
        return service.save(plan);
    }

    @GetMapping("/user/{userId}")
    public List<BudgetPlan> getByUser(@PathVariable Long userId) {
        return service.getByUserId(userId);
    }
}
