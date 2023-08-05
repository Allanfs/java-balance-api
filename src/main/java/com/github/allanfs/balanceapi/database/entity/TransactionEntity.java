package com.github.allanfs.balanceapi.database.entity;


import com.github.allanfs.balanceapi.domain.model.TransactionNature;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private float amount;
    private TransactionNature nature;
    private java.util.Date expiresIn;
    private boolean isPaid;
    private java.util.Date paidAt;
    
}
