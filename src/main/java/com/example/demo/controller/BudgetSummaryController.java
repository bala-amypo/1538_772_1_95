@RestController
@RequestMapping("/summary")
public class BudgetSummaryController {

    @PostMapping("/generate/{budgetPlanId}")
    public BudgetSummary generate(@PathVariable Long budgetPlanId) {
        BudgetPlan plan = planRepo.findById(budgetPlanId).orElseThrow();
        double expense = 0;
        double income = 0;

        String status = expense <= plan.getExpenseLimit()
                ? "UNDER_LIMIT" : "OVER_LIMIT";

        BudgetSummary summary = new BudgetSummary();
        summary.setBudgetPlan(plan);
        summary.setTotalExpense(expense);
        summary.setTotalIncome(income);
        summary.setStatus(status);

        return summaryRepo.save(summary);
    }

    @GetMapping("/{budgetPlanId}")
    public BudgetSummary get(@PathVariable Long budgetPlanId) {
        return summaryRepo.findByBudgetPlan(planRepo.findById(budgetPlanId).orElseThrow()).orElseThrow();
    }
}