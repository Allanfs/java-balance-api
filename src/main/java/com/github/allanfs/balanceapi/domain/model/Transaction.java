package com.github.allanfs.balanceapi.domain.model;

import java.util.Date;

import lombok.Data;

@Data
public class Transaction {
    private int id;
    private String name;
    private float amount;
    private TransactionNature nature;
    private Date expiresIn;
    private boolean isPaid;
    private Date paidAt;

    private TransactionRecurrency recurrency;

    public boolean hasRecurrency() {
        return recurrency != null;
    }
}
