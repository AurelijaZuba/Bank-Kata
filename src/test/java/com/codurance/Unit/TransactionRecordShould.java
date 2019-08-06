package com.codurance.Unit;

import com.codurance.Transaction;
import com.codurance.TransactionRecord;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TransactionRecordShould {

    public static final int AMOUNT = 30;

    @Test
    void add_deposit() {
        List<Transaction> transactionList = mock(List.class);

        TransactionRecord transactionRecord = new TransactionRecord(transactionList);
        transactionRecord.addDeposit(AMOUNT);

        verify(transactionList).add(isA(Transaction.class));
    }

    @Test
    void add_withdraw() {
        List<Transaction> transactionList = mock(List.class);

        TransactionRecord transactionRecord = new TransactionRecord(transactionList);
        transactionRecord.addWithdraw(AMOUNT);

        verify(transactionList).add(isA(Transaction.class));
    }

    @Test
    void add_deposit_transaction_with_correct_amount() {
        List<Transaction> transactionList = mock(List.class);

        TransactionRecord transactionRecord = new TransactionRecord(transactionList);
        transactionRecord.addDeposit(AMOUNT);

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionList).add(argument.capture());

        assertThat(argument.getValue().amount()).isEqualTo(AMOUNT);
    }

    @Test
    void add_deposit_transaction_with_correct_balance() {
        int balance = 30;
        List<Transaction> transactionList = mock(List.class);

        TransactionRecord transactionRecord = new TransactionRecord(transactionList);
        transactionRecord.addDeposit(AMOUNT);

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionList).add(argument.capture());

        assertThat(argument.getValue().balance()).isEqualTo(balance);
    }
}
