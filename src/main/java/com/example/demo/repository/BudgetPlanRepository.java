public interface BudgetPlanRepository extends JpaRepository<BudgetPlan, Long> {
    Optional<BudgetPlan> findByUserAndMonthAndYear(User user, Integer month, Integer year);
}