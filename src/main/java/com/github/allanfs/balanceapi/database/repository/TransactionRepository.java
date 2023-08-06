package com.github.allanfs.balanceapi.database.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import com.github.allanfs.balanceapi.database.entity.TransactionEntity;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long>{

    Iterable<TransactionEntity> findAllByCreatedAtBetween(Date start, Date end);
}
