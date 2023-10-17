package com.github.allanfs.balanceapi.domain.transaction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.allanfs.balanceapi.database.entity.TransactionEntity;
import com.github.allanfs.balanceapi.database.repository.TransactionRepository;
import com.github.allanfs.balanceapi.domain.model.Transaction;
import com.github.allanfs.balanceapi.mappers.TransactionMapper;

@Service
public class TransactionService {
        
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RecurrencyService recurrencyService;
    public com.github.allanfs.balanceapi.database.entity.TransactionEntity createTransaction(Transaction transaction) {
        if (transaction.hasRecurrency()) {
            var transactions = recurrencyService.createTransactions(transaction.getRecurrency());
            var savedTransactions = transactionRepository.saveAll(TransactionMapper.INSTANCE.transactionsToEntityList(transactions));

            return savedTransactions.iterator().next();
        }
        
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

    public Iterable<TransactionEntity> getTransactionsByMonth(Integer year, Integer month) throws ParseException {
        SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
        Date monthStart = sdf.parse(year.toString() + "-"+month.toString()+"-01");
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(monthStart); 
        calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DATE));
        
        return transactionRepository.findAllByExpiresInBetween(monthStart, calendar.getTime());
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
