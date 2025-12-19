package com.example.demo.controller;


import com.example.demo.model.TransactionLog;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/transactions")
public class TransactionController {


private final TransactionService transactionService;


public TransactionController(TransactionService transactionService) {
this.transactionService = transactionService;
}


@PostMapping("/{userId}")
public TransactionLog add(@PathVariable Long userId,
@RequestBody TransactionLog log) {
return transactionService.addTransaction(userId, log);
}


@GetMapping("/user/{userId}")
public List<TransactionLog> getUserTransactions(@PathVariable Long userId) {
return transactionService.getUserTransactions(userId);
}
}