package com.example.demo.controller;

import com.example.demo.model.BudgetPlan;
import com.example.demo.model.User;
import com.example.demo.service.BudgetPlanService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget-plans")
public class BudgetPlanController {

    private final BudgetPlanService budgetPlanService;
    private final UserService userService;

    public BudgetPlanController(
            BudgetPlanService budgetPlanService,
            UserService userService
    ) {
        this.budgetPlanService = budgetPlanService;
        this.userService = userService;
    }

    // ---------------- CREATE ----------------
    @PostMapping
    public BudgetPlan create(
            @RequestParam Long userId,
            @RequestParam Integer month,
            @RequestParam Integer year,
            @RequestParam Double limitAmount
    ) {
        User user = userService.getById(userId);

        BudgetPlan plan = new BudgetPlan();
        plan.setUser(user);
        plan.setMonth(month);
        plan.setYear(year);
        plan.setLimitAmount(limitAmount);

        return budgetPlanService.save(plan);
    }

    @GetMapping
    public List<BudgetPlan> getAll() {
        return budgetPlanService.getAll();
    }

    @GetMapping("/{id}")
    public BudgetPlan getById(@PathVariable Long id) {
        return budgetPlanService.getById(id);
    }

    @GetMapping("/user/{userId}")
    public List<BudgetPlan> getByUser(@PathVariable Long userId) {
        return budgetPlanService.getByUserId(userId);
    }

    @GetMapping("/search")
    public BudgetPlan getByUserAndMonthAndYear(
            @RequestParam Long userId,
            @RequestParam Integer month,
            @RequestParam Integer year
    ) {
        return budgetPlanService.getByUserAndMonthAndYear(userId, month, year);
    }
}
