package com.codurance.Unit;

import com.codurance.LocalClock;
import com.codurance.Transaction;
import com.codurance.TransactionRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.stubbing.OngoingStubbing;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TransactionRecordShould {

    public static final int AMOUNT = 30;
    private List<Transaction> transactionsListMock;
    private LocalClock clockMock;
    private final LocalDateTime dateTime = LocalDateTime.of(2019, Month.AUGUST, 02, 15, 19);
    private ArgumentCaptor<Transaction> argument;

    @BeforeEach
    void setUp() {
        transactionsListMock = mock(List.class);
        clockMock = mock(LocalClock.class);
        when(clockMock.now()).thenReturn(dateTime);
        argument = ArgumentCaptor.forClass(Transaction.class);
    }

    @Test
    void add_deposit_with_valid_transaction() {
        int balance = 30;

        TransactionRecord transactionRecord = new TransactionRecord(transactionsListMock, clockMock);
        transactionRecord.addDeposit(AMOUNT);

        verify(transactionsListMock).add(argument.capture());

        assertThat(argument.getValue().date()).isEqualTo(dateTime);
        assertThat(argument.getValue().amount()).isEqualTo(AMOUNT);
        assertThat(argument.getValue().balance()).isEqualTo(balance);
    }

    @Test
    void add_withdraw_with_valid_transaction() {
        int balance = -30;

        TransactionRecord transactionRecord = new TransactionRecord(transactionsListMock, clockMock);
        transactionRecord.addWithdraw(AMOUNT);

        verify(transactionsListMock).add(argument.capture());

        assertThat(argument.getValue().date()).isEqualTo(dateTime);
        assertThat(argument.getValue().amount()).isEqualTo(-AMOUNT);
        assertThat(argument.getValue().balance()).isEqualTo(balance);
    }

    @Test
    void return_a_list_of_transactions_ordered_by_most_recent() {
        Transaction transaction1 = new Transaction(dateTime, 30, 60);
        Transaction transaction2 = new Transaction(dateTime, 20, 30);
        Transaction transaction3 = new Transaction(dateTime, 10, 10);

        final List<Transaction> transactionList = asList(transaction1, transaction2, transaction3);

        TransactionRecord transactionRecord = new TransactionRecord(transactionList, clockMock);
        List<Transaction> orderedTransactions = transactionRecord.getTransactionsOrderedByDate();

        assertThat(orderedTransactions.get(0)).isEqualTo(transaction3);
        assertThat(orderedTransactions.get(1)).isEqualTo(transaction2);
        assertThat(orderedTransactions.get(2)).isEqualTo(transaction1);
    }
}
