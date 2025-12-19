public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long> {
List<TransactionLog> findByUser(User user);
List<TransactionLog> findByUserAndTransactionDateBetween(User user, LocalDate start, LocalDate end);
}