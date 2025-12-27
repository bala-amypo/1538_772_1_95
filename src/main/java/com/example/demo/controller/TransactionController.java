package com.example.demo.controller;

import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    public TransactionLog add(@PathVariable Long userId,
                              @RequestBody TransactionLog log) {
        return service.addTransaction(userId, log);
    }

    @GetMapping("/user/{userId}")
    public List<TransactionLog> getUserTx(@PathVariable Long userId) {
        return service.getUserTransactions(userId);
    }
}
