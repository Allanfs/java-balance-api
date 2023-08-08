package com.github.allanfs.balanceapi.http.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TransactionSummary {
    private float credit;
    private float debit;
    private float net;
}
