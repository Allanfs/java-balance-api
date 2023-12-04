package com.github.allanfs.balanceapi.domain.transaction;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.allanfs.balanceapi.domain.model.Transaction;

@Service
public class RecurrencyService {

    List<Transaction> createTransactions(Transaction tre) {
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();
        var installmentAmount = tre.getAmountPerInstallment();

        var transactionRecurrecy = tre.getRecurrency();
        for (int i = 0; i < transactionRecurrecy.getTotalInstallments(); i++) {
            Transaction transaction = new Transaction();
            
            try {
                BeanUtils.copyProperties(transaction, tre);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            transactions.add(transaction);

            if (i >0) {
                Transaction prevTransaction=transactions.get(i-1);
                transaction.setExpiresIn( transactionRecurrecy.getRecurrency().Increment(prevTransaction.getExpiresIn()) );
            }

            transaction.setName(newInstallmentName(transaction.getName(),i+1, transactionRecurrecy.getTotalInstallments()));
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
