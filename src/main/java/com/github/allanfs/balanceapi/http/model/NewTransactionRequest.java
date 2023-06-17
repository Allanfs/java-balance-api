package com.github.allanfs.balanceapi.http.model;

import java.util.Date;

import com.github.allanfs.balanceapi.domain.model.Transaction;

import lombok.Data;

@Data
public class NewTransactionRequest {
    private String name;
    private float value;
    private String nature;
    private Date expiresIn;
    private boolean isPaid;
    private Date paidAt;

    public Transaction parseToTransaction() {
        Transaction transaction = new Transaction();
        transaction.setName(this.name);
        transaction.setValue(this.value);
        transaction.setNature(this.nature);
        transaction.setExpiresIn(this.expiresIn);
        transaction.setPaid(this.isPaid);
        transaction.setPaidAt(this.paidAt);
        return transaction;
    }
}
