package com.codurance.Unit;

import com.codurance.AccountService;
import com.codurance.BankStatement;
import com.codurance.ConsoleWrite;
import com.codurance.TransactionRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.*;

public class AccountServiceShould {


    private List<Integer> transactionListMock;
    private ConsoleWrite consoleMock;
    private BankStatement bankStatement;

    @BeforeEach
    void setUp() {
        transactionListMock = mock(List.class);
        consoleMock = mock(ConsoleWrite.class);
        bankStatement = mock(BankStatement.class);
    }

    @Test
    void deposit_amount() {
        int amount = 10;
        AccountService accountService = new AccountService(consoleMock, transactionListMock, bankStatement);

        accountService.deposit(amount);

        verify(transactionListMock).add(amount);
    }

    @Test
    void deposit_amount1() {
        int amount = 10;
        TransactionRecord transactionRecords = mock(TransactionRecord.class);
        AccountService accountService = new AccountService(consoleMock, transactionRecords, bankStatement);

        accountService.deposit1(amount);

        verify(transactionRecords).addDeposit(amount);
    }


    @Test
    void withdraw_amount() {
        int amount = 10;
        AccountService accountService = new AccountService(consoleMock, transactionListMock, bankStatement);

        accountService.withdraw(amount);

        verify(transactionListMock).add(-amount);
    }

    @Test
    void withdraw_amount1() {
        int amount = 10;
        TransactionRecord transactionRecords = mock(TransactionRecord.class);
        AccountService accountService = new AccountService(consoleMock, transactionRecords, bankStatement);

        accountService.withdraw1(amount);

        verify(transactionRecords).addWithdraw(amount);
    }

    @Test
    void printStatement() {
        List<Integer> listOfTransactions = asList(20, -20);
        final String statementHeader = "Date || Amount || Balance";
        final String transaction1 = "01/08/2019 || -20 || 0";
        final String transaction2 = "01/08/2019 || 20  || 20";

        final List<String> statementLines = asList(statementHeader, transaction1, transaction2);
        when(bankStatement.generate(listOfTransactions)).thenReturn(statementLines);

        AccountService accountService = new AccountService(consoleMock, listOfTransactions, bankStatement);
        accountService.printStatement();

        verify(bankStatement).generate(listOfTransactions);
        verify(consoleMock).print(statementHeader);
        verify(consoleMock).print(transaction1);
        verify(consoleMock).print(transaction2);
    }

    @Test
    void printStatement1() {
        TransactionRecord transactionRecord = mock(TransactionRecord.class);
        final String statementHeader = "Date || Amount || Balance";
        final String transaction1 = "01/08/2019 || -20 || 0";
        final String transaction2 = "01/08/2019 || 20  || 20";

        final List<String> statementLines = asList(statementHeader, transaction1, transaction2);
        when(bankStatement.generate(transactionRecord)).thenReturn(statementLines);

        AccountService accountService = new AccountService(consoleMock, transactionRecord, bankStatement);
        accountService.printStatement1();

        verify(bankStatement).generate(transactionRecord);
        verify(consoleMock).print(statementHeader);
        verify(consoleMock).print(transaction1);
        verify(consoleMock).print(transaction2);
    }
}
