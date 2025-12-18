package com.example.budget.service;

import com.example.budget.model.TransactionLog;
import java.util.List;

public interface TransactionService {
    TransactionLog addTransaction(Long userId, TransactionLog log);
    List<TransactionLog> getUserTransactions(Long userId);
}
