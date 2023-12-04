package com.github.allanfs.balanceapi.domain.transaction;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.allanfs.balanceapi.domain.model.Recurrency;
import com.github.allanfs.balanceapi.domain.model.Transaction;
import com.github.allanfs.balanceapi.domain.model.TransactionNature;
import com.github.allanfs.balanceapi.domain.model.TransactionRecurrency;

public class RecurrencyServiceTest {
    @Test
    void testCreateTransactions() {
        
        final int TOTAL_INSTALLMENTS = 5;
        
        var rs = new RecurrencyService();
        var tr = new TransactionRecurrency();
        tr.setRecurrency(Recurrency.MONTH);
        tr.setTotalInstallments(TOTAL_INSTALLMENTS);
        
        var origTr = new Transaction();
        origTr.setName("Test");
        origTr.setAmount(1000);
        origTr.setNature(TransactionNature.CREDIT);
        origTr.setRecurrency(tr);
        
        origTr.setExpiresIn(newExpirationDate());
        
        Assertions.assertEquals(TOTAL_INSTALLMENTS, tr.getTotalInstallments());
        
        var transactions = rs.createTransactions(origTr);
        
        var stTr = transactions.get(0);
        
        Assertions.assertEquals(String.format("Test 1/%d",TOTAL_INSTALLMENTS),stTr.getName());
        Assertions.assertEquals(200, stTr.getAmount());
        Assertions.assertEquals(origTr.getNature(), stTr.getNature(), "a transacao deve ser de mesma natureza da original");
        Assertions.assertFalse(stTr.isPaid(), "nenhuma transacao deve estar paga");
        
        
        Assertions.assertEquals(tr.getTotalInstallments(), transactions.size(), "a qtd de transacoes deve ser o mesmo numero de parcelas");
        
    }
    
    private Date newExpirationDate() {
        var expiresIn = Calendar.getInstance();
        expiresIn.set(2023, 10,23);
        return expiresIn.getTime();
    }
}
