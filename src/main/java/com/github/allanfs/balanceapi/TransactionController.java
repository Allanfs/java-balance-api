package com.github.allanfs.balanceapi;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.allanfs.balanceapi.database.entity.TransactionEntity;
import com.github.allanfs.balanceapi.domain.model.TransactionNature;
import com.github.allanfs.balanceapi.domain.transaction.TransactionService;
import com.github.allanfs.balanceapi.http.model.NewTransactionRequest;
import com.github.allanfs.balanceapi.http.model.TransactionHttp;
import com.github.allanfs.balanceapi.http.model.TransactionSummary;


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
    public TransactionHttp getTransactions() {
        List<TransactionEntity> lte = new ArrayList<TransactionEntity>();
        float totalDebit = 0f;
        float totalCredit = 0f;

        for (TransactionEntity transaction : transactionService.getTransactions()) {
            lte.add(transaction);
            if (transaction.getNature().equals(TransactionNature.CREDIT)) {
                totalCredit += transaction.getAmount();
            } else {
                totalDebit += transaction.getAmount();
            }
        }
        TransactionSummary summary = new TransactionSummary(totalCredit, totalDebit, totalCredit+(totalDebit *-1));

        TransactionHttp response = new TransactionHttp();
        response.setTransactions(lte);
        response.setSummary(summary);
        return response;
    }
    
    @GetMapping("/year/{year}/month/{month}")
    public Iterable<TransactionEntity> getTransactionsInMonth(@PathVariable int year, @PathVariable int month) throws ParseException {
        return transactionService.getTransactionsByMonth(year, month);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
}
