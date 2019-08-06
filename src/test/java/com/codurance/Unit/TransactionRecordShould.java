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
import java.util.List;

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
    void add_withdraw() {
        TransactionRecord transactionRecord = new TransactionRecord(transactionsListMock, clockMock);
        transactionRecord.addWithdraw(AMOUNT);

        verify(transactionsListMock).add(isA(Transaction.class));
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
}
