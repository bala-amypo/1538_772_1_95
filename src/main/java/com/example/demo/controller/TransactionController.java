package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public TransactionLog createTransaction(@RequestBody TransactionLog transactionLog) {
        return transactionService.save(transactionLog);
    }

    @GetMapping
    public List<TransactionLog> getAllTransactions() {
        return transactionService.findAll();
    }
}
