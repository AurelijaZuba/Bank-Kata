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

    @Test
    void add_deposit() {
        int amount = 30;
        List<Transaction> transactionList = mock(List.class);

        TransactionRecord transactionRecord = new TransactionRecord(transactionList);
        transactionRecord.addDeposit(amount);

        verify(transactionList).add(isA(Transaction.class));
    }

    @Test
    void add_withdraw() {
        int amount = 30;
        List<Transaction> transactionList = mock(List.class);

        TransactionRecord transactionRecord = new TransactionRecord(transactionList);
        transactionRecord.addWithdraw(amount);

        verify(transactionList).add(isA(Transaction.class));
    }

    @Test
    void add_deposit_transaction_with_correct_amount() {
        int amount = 30;
        List<Transaction> transactionList = mock(List.class);

        TransactionRecord transactionRecord = new TransactionRecord(transactionList);
        transactionRecord.addDeposit(amount);

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionList).add(argument.capture());

        assertThat(argument.getValue().amount()).isEqualTo(amount);
    }

    @Test
    void add_deposit_transaction_with_correct_balance() {
        int amount = 30;
        int balance = 30;
        List<Transaction> transactionList = mock(List.class);

        TransactionRecord transactionRecord = new TransactionRecord(transactionList);
        transactionRecord.addDeposit(amount);

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionList).add(argument.capture());

        assertThat(argument.getValue().balance()).isEqualTo(balance);
    }
}
