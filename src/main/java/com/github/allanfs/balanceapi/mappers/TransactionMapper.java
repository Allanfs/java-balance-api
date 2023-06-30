package com.github.allanfs.balanceapi.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.github.allanfs.balanceapi.database.entity.TransactionEntity;
import com.github.allanfs.balanceapi.domain.model.Transaction;

@Mapper
public interface TransactionMapper {
    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction transactionEntityToTransaction(TransactionEntity transactionEntity);
    
    TransactionEntity transactionToTransactionEntity(Transaction transaction);
}
