package com.example.budget.service.impl;

import com.example.budget.model.TransactionLog;
import com.example.budget.repository.TransactionRepository;
import com.example.budget.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public TransactionLog addTransaction(Long userId, TransactionLog log) {
        log.setUserId(userId);
        return transactionRepository.save(log);
    }

    @Override
    public List<TransactionLog> getUserTransactions(Long userId) {
        return transactionRepository.findByUserId(userId);
    }
}
