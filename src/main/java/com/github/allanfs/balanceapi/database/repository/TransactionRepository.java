package com.github.allanfs.balanceapi.database.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.allanfs.balanceapi.database.entity.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long>{
    
}
