@RestController
@RequestMapping("/budgets")
public class BudgetPlanController {

    @PostMapping("/{userId}")
    public BudgetPlan create(@PathVariable Long userId,
                             @RequestBody BudgetPlan plan) {
        if(plan.getMonth() < 1 || plan.getMonth() > 12)
            throw new RuntimeException("Invalid month");
        return repo.save(plan);
    }

    @GetMapping("/{userId}/{month}/{year}")
    public BudgetPlan getPlan(@PathVariable Long userId,
                              @PathVariable Integer month,
                              @PathVariable Integer year) {
        return repo.findByUserAndMonthAndYear(user, month, year).orElseThrow();
    }
}