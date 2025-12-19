@Entity
public class BudgetSummary {

    @Id 
    @GeneratedValue
    private Long id;

    @OneToOne
    private BudgetPlan budgetPlan;

    private Double totalIncome;
    private Double totalExpense;

    private String status; // UNDER_LIMIT / OVER_LIMIT

    @PrePersist
    public void setTimestamp() {
        generatedAt = LocalDateTime.now();
    }

    private LocalDateTime generatedAt;
}