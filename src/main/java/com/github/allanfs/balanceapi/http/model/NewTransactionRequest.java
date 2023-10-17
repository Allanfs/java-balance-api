package com.github.allanfs.balanceapi.http.model;

import java.util.Date;

import com.github.allanfs.balanceapi.domain.model.Transaction;
import com.github.allanfs.balanceapi.domain.model.TransactionNature;
import com.github.allanfs.balanceapi.domain.model.TransactionRecurrency;

import lombok.Data;

@Data
public class NewTransactionRequest {
    private String name;
    private float value;
    private TransactionNature nature;
    private Date expiresIn;
    private boolean isPaid;
    private Date paidAt;
    private boolean hasRecurrency;
    private TransactionRecurrency recurrency;

    public Transaction parseToTransaction() {
        Transaction transaction = new Transaction();
        transaction.setName(this.name);
        transaction.setAmount(this.value);
        transaction.setNature(this.nature);
        transaction.setExpiresIn(this.expiresIn);
        transaction.setPaid(this.isPaid);
        transaction.setPaidAt(this.paidAt);
        return transaction;
    }
}
