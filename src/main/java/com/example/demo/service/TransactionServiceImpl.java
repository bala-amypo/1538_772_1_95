package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository transactionRepository;

    public TransactionServiceImpl(TransactionLogRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public TransactionLog save(TransactionLog transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public List<TransactionLog> getAll() {
        return transactionRepository.findAll();
    }

    @Override
    public List<TransactionLog> getByCategory(Long categoryId) {
        return transactionRepository.findByCategoryId(categoryId);
    }
}
