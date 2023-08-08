package com.github.allanfs.balanceapi.http.model;

import java.util.List;

import com.github.allanfs.balanceapi.database.entity.TransactionEntity;

import lombok.Data;

@Data
public class TransactionHttp {
    private List<TransactionEntity> transactions;
    private TransactionSummary summary;
}

