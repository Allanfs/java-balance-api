package com.github.allanfs.balanceapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.balanceapi.database.entity.Transaction;
import com.github.allanfs.balanceapi.domain.transaction.TransactionService;
import com.github.allanfs.balanceapi.http.model.NewTransactionRequest;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction createTransaction(@RequestBody NewTransactionRequest request) {
        return transactionService.createTransaction(request.parseToTransaction());
    }

    @GetMapping
    public Iterable<Transaction> getTransactions() {
        return transactionService.getTransactions();
    }
}
