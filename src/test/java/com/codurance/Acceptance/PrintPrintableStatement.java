package com.codurance.Acceptance;

import com.codurance.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PrintPrintableStatement {

    @Test
    void AcceptanceTest() {
        ConsoleWrite consoleMock = mock(ConsoleWrite.class);

        LocalClock clockMock = mock(LocalClock.class);
        when(clockMock.now())
                .thenReturn(LocalDateTime.of(2012, Month.JANUARY, 10, 9, 00))
                .thenReturn(LocalDateTime.of(2012, Month.JANUARY, 13, 9, 00))
                .thenReturn(LocalDateTime.of(2012, Month.JANUARY, 14, 9, 00));

        List<Transaction> transactions = new ArrayList<>();
        TransactionRecord transactionRecord = new TransactionRecord(transactions, clockMock);

        StatementFormatter statementFormatter = new PrintableStatement();

        AccountService accountService = new AccountService(consoleMock, transactionRecord, statementFormatter);
        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.withdraw(500);
        accountService.printStatement();


        InOrder inOrder = inOrder(consoleMock);
        inOrder.verify(consoleMock).print("Date || Amount || Balance");
        inOrder.verify(consoleMock).print("14/01/2012\t||\t-500\t||\t2500");
        inOrder.verify(consoleMock).print("13/01/2012\t||\t2000\t||\t3000");
        inOrder.verify(consoleMock).print("10/01/2012\t||\t1000\t||\t1000");

    }
}
