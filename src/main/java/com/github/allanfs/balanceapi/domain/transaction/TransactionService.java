package com.github.allanfs.balanceapi.domain.transaction;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.balanceapi.database.repository.TransactionRepository;
import com.github.allanfs.balanceapi.domain.model.Transaction;

@Service
public class TransactionService {
        
    @Autowired
    private TransactionRepository transactionRepository;

    public com.github.allanfs.balanceapi.database.entity.TransactionEntity createTransaction(Transaction transaction) {
        com.github.allanfs.balanceapi.database.entity.TransactionEntity transactionEntity = new com.github.allanfs.balanceapi.database.entity.TransactionEntity();
        transactionEntity.setAmount(transaction.getAmount());
        transactionEntity.setExpiresIn(transaction.getExpiresIn());
        transactionEntity.setPaid(transaction.isPaid());
        transactionEntity.setName(transaction.getName());
        transactionEntity.setNature(transaction.getNature());
        transactionEntity.setPaidAt(transaction.getPaidAt());

        return transactionRepository.save(transactionEntity);
    }

    public Iterable<com.github.allanfs.balanceapi.database.entity.TransactionEntity> getTransactions() {
        Iterable<com.github.allanfs.balanceapi.database.entity.TransactionEntity> transactions = transactionRepository.findAll();
        BeanUtils.copyProperties(transactionRepository.findAll(), transactions);
        return transactions;
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
