package com.github.allanfs.balanceapi.http.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.github.allanfs.balanceapi.domain.model.Transaction;

@Mapper
public interface HttpTransactionMapper {
    HttpTransactionMapper INSTANCE = Mappers.getMapper(HttpTransactionMapper.class);

    @Mapping(source = "value", target = "amount")
    Transaction toModelTransaction(NewTransactionRequest newTransaction);
    
}
