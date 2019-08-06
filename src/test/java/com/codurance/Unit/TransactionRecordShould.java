package com.codurance.Unit;

import com.codurance.LocalClock;
import com.codurance.Transaction;
import com.codurance.TransactionRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class TransactionRecordShould {

    public static final int AMOUNT = 30;
    private List<Transaction> transactionsListMock;
    private LocalClock clockMock;

    @BeforeEach
    void setUp() {
        transactionsListMock = mock(List.class);
        clockMock = mock(LocalClock.class);
    }

    @Test
    void add_deposit_with_valid_transaction() {
        final LocalDateTime dateTime = LocalDateTime.of(2019, Month.AUGUST, 02, 15, 19);
        int balance = 30;

        when(clockMock.now()).thenReturn(dateTime);

        TransactionRecord transactionRecord = new TransactionRecord(transactionsListMock, clockMock);
        transactionRecord.addDeposit(AMOUNT);

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionsListMock).add(argument.capture());

        assertThat(argument.getValue().date()).isEqualTo(dateTime);
        assertThat(argument.getValue().amount()).isEqualTo(AMOUNT);
        assertThat(argument.getValue().balance()).isEqualTo(balance);
    }

    @Test
    void add_withdraw_with_valid_transaction() {
        final LocalDateTime dateTime = LocalDateTime.of(2019, Month.AUGUST, 02, 15, 19);
        int balance = -30;

        when(clockMock.now()).thenReturn(dateTime);

        TransactionRecord transactionRecord = new TransactionRecord(transactionsListMock, clockMock);
        transactionRecord.addWithdraw(AMOUNT);

        ArgumentCaptor<Transaction> argument = ArgumentCaptor.forClass(Transaction.class);
        verify(transactionsListMock).add(argument.capture());

        assertThat(argument.getValue().date()).isEqualTo(dateTime);
        assertThat(argument.getValue().amount()).isEqualTo(-AMOUNT);
        assertThat(argument.getValue().balance()).isEqualTo(balance);
    }

    @Test
    void return_a_list_of_transactions_ordered_by_most_recent() {
        final LocalDateTime dateTime = LocalDateTime.of(2019, Month.AUGUST, 02, 15, 19);
        Transaction transaction3 = new Transaction(dateTime, 10, 10);
        Transaction transaction2 = new Transaction(dateTime, 20, 30);
        Transaction transaction1 = new Transaction(dateTime, 30, 60);

        final List<Transaction> transactionList = asList(transaction1, transaction2, transaction3);

        TransactionRecord transactionRecord = new TransactionRecord(transactionList, clockMock);
        List<Transaction> orderedTransactions = transactionRecord.getTransactionsOrderedByDate();

        assertThat(orderedTransactions.get(0)).isEqualTo(transaction3);
        assertThat(orderedTransactions.get(1)).isEqualTo(transaction2);
        assertThat(orderedTransactions.get(2)).isEqualTo(transaction1);
    }
}
