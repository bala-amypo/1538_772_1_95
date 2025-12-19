package com.example.demo.service.impl;

import com.example.demo.model.TransactionLog;
import com.example.demo.repository.TransactionLogRepository;
import com.example.demo.service.TransactionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionLogRepository transactionLogRepository;

    public TransactionServiceImpl(TransactionLogRepository transactionLogRepository) {
        this.transactionLogRepository = transactionLogRepository;
    }

    @Override
    public TransactionLog save(TransactionLog transactionLog) {
        return transactionLogRepository.save(transactionLog);
    }

    @Override
    public List<TransactionLog> findAll() {
        return transactionLogRepository.findAll();
    }
}
