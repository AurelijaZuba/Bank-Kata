package com.codurance;

import org.junit.jupiter.api.Test;

import java.sql.Statement;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountServiceShould {


    @Test
    void deposit_amount() {
        int amount = 10;
        List<Integer> balanceListMock = mock(List.class);
        ConsoleWrite consoleMock = mock(ConsoleWrite.class);

        AccountService accountService = new AccountService(consoleMock, balanceListMock);
        accountService.deposit(amount);

        verify(balanceListMock).add(amount);
    }


    @Test
    void withdraw_amount() {
        int amount = 10;
        List<Integer> balanceListMock = mock(List.class);
        ConsoleWrite consoleMock = mock(ConsoleWrite.class);

        AccountService accountService = new AccountService(consoleMock, balanceListMock);
        accountService.withdraw(amount);

        verify(balanceListMock).add(-amount);
    }

    @Test
    void printStatement() {
        List<Integer> balanceListMock = mock(List.class);
        BankStatement bankStatement = mock(BankStatement.class);
        ConsoleWrite consoleMock = mock(ConsoleWrite.class);

        AccountService accountService = new AccountService(consoleMock, balanceListMock);
        accountService.printStatement();

        verify(bankStatement).generate(balanceListMock);
    }
}
