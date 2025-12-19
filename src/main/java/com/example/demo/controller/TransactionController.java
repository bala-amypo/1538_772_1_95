@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @PostMapping("/{userId}")
    public TransactionLog add(@PathVariable Long userId,
                              @RequestBody TransactionLog log) {
        if(log.getAmount() <= 0)
            throw new RuntimeException("Invalid amount");
        if(log.getTransactionDate().isAfter(LocalDate.now()))
            throw new RuntimeException("Future date not allowed");
        return repo.save(log);
    }
}