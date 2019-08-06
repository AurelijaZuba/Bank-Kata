package com.codurance.Unit;

import com.codurance.Transaction;
import com.codurance.TransactionRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TransactionRecordShould {

    @Test
    void add_deposit() {
        int amount = 30;
        List<Transaction> transactionList = mock(List.class);

        TransactionRecord transactionRecord = new TransactionRecord(transactionList);
        transactionRecord.addDeposit(amount);

        verify(transactionList).add(isA(Transaction.class));
    }
}
