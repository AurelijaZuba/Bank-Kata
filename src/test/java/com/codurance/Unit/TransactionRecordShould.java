package com.codurance.Unit;

import com.codurance.Transaction;
import com.codurance.TransactionRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TransactionRecordShould {

    public static final int AMOUNT = 30;
    private List<Transaction> transactionsListMock;

    @BeforeEach
    void setUp() {
        transactionsListMock = mock(List.class);
    }

    @Test
    void add_deposit() {
        TransactionRecord transactionRecord = new TransactionRecord(transactionsListMock);
        transactionRecord.addDeposit(AMOUNT);

        verify(transactionsListMock).add(isA(Transaction.class));
    }

    @Test
    void add_withdraw() {
        TransactionRecord transactionRecord = new TransactionRecord(transactionsListMock);
        transactionRecord.addWithdraw(AMOUNT);

        verify(transactionsListMock).add(isA(Transaction.class));
    }

    @Test
    void add_deposit_transaction_with_correct_amount() {
        TransactionRecord transactionRecord = new TransactionRecord(transactionsListMock);
        transactionRecord.addDeposit(AMOUNT);

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionsListMock).add(argument.capture());

        assertThat(argument.getValue().amount()).isEqualTo(AMOUNT);
    }

    @Test
    void add_deposit_transaction_with_correct_balance() {
        int balance = 30;
        TransactionRecord transactionRecord = new TransactionRecord(transactionsListMock);
        transactionRecord.addDeposit(AMOUNT);

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionsListMock).add(argument.capture());

        assertThat(argument.getValue().balance()).isEqualTo(balance);
    }
}
