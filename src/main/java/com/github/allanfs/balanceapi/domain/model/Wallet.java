package com.github.allanfs.balanceapi.domain.model;

import java.sql.Date;
import java.util.List;

import lombok.Data;

@Data
public class Wallet {
    private long id;
    private String name;
    private Date createDate;
    private List<Transaction> transactions;
}
