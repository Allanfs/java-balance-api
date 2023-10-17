package com.github.allanfs.balanceapi.domain.transaction;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.allanfs.balanceapi.domain.model.Transaction;
import com.github.allanfs.balanceapi.domain.model.TransactionRecurrency;

@Service
public class RecurrencyService {
    
    List<Transaction> createTransactions(TransactionRecurrency rec) {

        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        var installmentAmount = rec.getOriginalTransaction().getAmount() / rec.getTotalInstallments();

        for (int i = 1; i <= rec.getTotalInstallments(); i++) {
            Transaction transaction = new Transaction();
            
            try {
                BeanUtils.copyProperties(transaction, rec.getOriginalTransaction());
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            transactions.add(transaction);


            Transaction prevTransaction= transaction;
            if (i > 1) {
                prevTransaction = transactions.get(i-2);
                transaction.setExpiresIn( rec.getRecurrency().Increment(prevTransaction.getExpiresIn()) );
            }

            transaction.setName(newInstallmentName(transaction.getName(),i, rec.getTotalInstallments()));
            transaction.setAmount(installmentAmount);

        }

        return transactions;
    }

    private String newInstallmentName(String origName, int current, int total) {
        var sb = new StringBuilder(origName + " ");
        sb.append(current).append("/").append(total);
        return sb.toString(); 
    }
}
