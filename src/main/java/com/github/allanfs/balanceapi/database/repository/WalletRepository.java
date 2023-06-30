package com.github.allanfs.balanceapi.database.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.allanfs.balanceapi.database.entity.WalletEntity;

public interface WalletRepository extends CrudRepository<WalletEntity, Long> {
    
}
