package com.github.allanfs.balanceapi.database.entity;

import java.util.Date;

import lombok.Data;

@Data
public class TransactionRecurrency {
    private Integer day;
    private Integer totalNumberOfOcurrencies;
    private Integer pastOcurrencies;
    private Date createdAt;
}
