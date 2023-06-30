package com.github.allanfs.balanceapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.balanceapi.database.entity.TransactionEntity;
import com.github.allanfs.balanceapi.domain.transaction.TransactionService;
import com.github.allanfs.balanceapi.http.model.NewTransactionRequest;


@RestController
@RequestMapping("/transaction")
public class TransactionController {
    
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public TransactionEntity createTransaction(@RequestBody NewTransactionRequest request) {
        return transactionService.createTransaction(request.parseToTransaction());
    }

    @GetMapping
    public Iterable<TransactionEntity> getTransactions() {
        return transactionService.getTransactions();
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
