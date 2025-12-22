package com.example.demo.repository;

import com.example.demo.model.TransactionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionLogRepository
        extends JpaRepository<TransactionLog, Long> {

    List<TransactionLog> findByCategoryId(Long categoryId);
}
