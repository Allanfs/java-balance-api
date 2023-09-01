package com.github.allanfs.balanceapi.domain;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.allanfs.balanceapi.database.entity.TransactionEntity;
import com.github.allanfs.balanceapi.database.repository.TransactionRepository;
import com.github.allanfs.balanceapi.domain.model.Transaction;
import com.github.allanfs.balanceapi.domain.model.TransactionNature;
import com.github.allanfs.balanceapi.domain.transaction.TransactionService;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {
    
    @Mock
    private TransactionRepository tr;

    @InjectMocks
    private TransactionService ts;

    @Test
    public void saveTransactionShouldSendCorrectInfoToRepository() {
        Transaction input = new Transaction();
        input.setAmount(10);
        input.setName("Meu Teste");
        input.setPaid(false);
        input.setNature(TransactionNature.CREDIT);
        

        TransactionEntity expetedInputToSave = new TransactionEntity();
        expetedInputToSave.setAmount(input.getAmount());
        expetedInputToSave.setName(input.getName());
        expetedInputToSave.setPaid(input.isPaid());
        expetedInputToSave.setNature(input.getNature());

        TransactionEntity mockedOutputFromSave = new TransactionEntity();
        mockedOutputFromSave.setAmount(input.getAmount());
        mockedOutputFromSave.setName(input.getName());
        mockedOutputFromSave.setPaid(input.isPaid());
        mockedOutputFromSave.setNature(input.getNature());
        mockedOutputFromSave.setId(1000);

        when(tr.save(expetedInputToSave)).thenReturn(mockedOutputFromSave);
        
        TransactionEntity te1 = ts.createTransaction(input);
        Assertions.assertEquals(1000, te1.getId());
        
    }
}
