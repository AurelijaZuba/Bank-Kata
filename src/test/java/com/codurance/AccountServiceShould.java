package com.codurance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountServiceShould {


    private List<Integer> transactionListMock;
    private ConsoleWrite consoleMock;
    private BankStatement bankStatement;
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        transactionListMock = mock(List.class);
        consoleMock = mock(ConsoleWrite.class);
        bankStatement = mock(BankStatement.class);
        accountService = new AccountService(consoleMock, transactionListMock, bankStatement);
    }

    @Test
    void deposit_amount() {
        int amount = 10;
        accountService.deposit(amount);

        verify(transactionListMock).add(amount);
    }


    @Test
    void withdraw_amount() {
        int amount = 10;
        accountService.withdraw(amount);

        verify(transactionListMock).add(-amount);
    }

    @Test
    void printStatement() {
        accountService.printStatement();

        verify(bankStatement).generate(transactionListMock);
    }
}
