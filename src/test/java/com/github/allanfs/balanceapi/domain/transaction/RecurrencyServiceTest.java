package com.github.allanfs.balanceapi.domain.transaction;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.github.allanfs.balanceapi.domain.model.Recurrency;
import com.github.allanfs.balanceapi.domain.model.Transaction;
import com.github.allanfs.balanceapi.domain.model.TransactionNature;
import com.github.allanfs.balanceapi.domain.model.TransactionRecurrency;

public class RecurrencyServiceTest {
    @Test
    void testCreateTransactions() {

        var rs = new RecurrencyService();
        var tr = new TransactionRecurrency();
        tr.setRecurrency(Recurrency.MONTH);
        tr.setTotalInstallments(5);

        var origTr = new Transaction();
        origTr.setName("Test");
        origTr.setAmount(1000);
        origTr.setNature(TransactionNature.CREDIT);
        tr.setOriginalTransaction(origTr);
        var transactions = rs.createTransactions(tr);
        
        var stTr = transactions.get(0);
        
        Assertions.assertEquals("Test 1/5",stTr.getName());
        Assertions.assertEquals(200, stTr.getAmount());
        Assertions.assertEquals(origTr.getNature(), stTr.getNature(), "a transacao deve ser de mesma natureza da original");
        Assertions.assertFalse(stTr.isPaid(), "nenhuma transacao deve estar paga");


        Assertions.assertEquals(tr.getTotalInstallments(), transactions.size(), "a qtd de transacoes deve ser o mesmo numero de parcelas");

    }
}
