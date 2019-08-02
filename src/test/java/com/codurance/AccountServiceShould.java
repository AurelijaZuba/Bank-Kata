package com.codurance;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountServiceShould {


    @Test
    void deposit_amount() {
        int amount = 10;
        List<Integer> balanceListMock = mock(List.class);
        ConsoleWrite consoleMock = mock(ConsoleWrite.class);
        BankStatement bankStatement = mock(BankStatement.class);

        AccountService accountService = new AccountService(consoleMock, balanceListMock, bankStatement);
        accountService.deposit(amount);

        verify(balanceListMock).add(amount);
    }


    @Test
    void withdraw_amount() {
        int amount = 10;
        List<Integer> balanceListMock = mock(List.class);
        ConsoleWrite consoleMock = mock(ConsoleWrite.class);
        BankStatement bankStatement = mock(BankStatement.class);

        AccountService accountService = new AccountService(consoleMock, balanceListMock, bankStatement);
        accountService.withdraw(amount);

        verify(balanceListMock).add(-amount);
    }

    @Test
    void printStatement() {
        List<Integer> balanceListMock = mock(List.class);
        ConsoleWrite consoleMock = mock(ConsoleWrite.class);
        BankStatement bankStatement = mock(BankStatement.class);

        AccountService accountService = new AccountService(consoleMock, balanceListMock, bankStatement);
        accountService.printStatement();

        verify(bankStatement).generate(balanceListMock);
    }
}
