public interface BudgetSummaryRepository extends JpaRepository<BudgetSummary, Long> {
Optional<BudgetSummary> findByBudgetPlan(BudgetPlan plan);
}