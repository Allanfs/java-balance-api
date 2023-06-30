package com.github.allanfs.balanceapi.database.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.allanfs.balanceapi.database.entity.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long>{
    
}
