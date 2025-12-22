package com.example.demo.service;

import com.example.demo.model.TransactionLog;
import java.util.List;

public interface TransactionService {
    TransactionLog save(TransactionLog transaction);
    List<TransactionLog> getAll();
    List<TransactionLog> getByCategory(Long categoryId);
}
