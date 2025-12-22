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

    @PostMapping
    public TransactionLog save(@RequestBody TransactionLog log) {
        return service.save(log);
    }

    @GetMapping
    public List<TransactionLog> getAll() {
        return service.getAll();
    }
}
