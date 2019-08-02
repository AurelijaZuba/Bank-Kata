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

        AccountService accountService = new AccountService(consoleMock, balanceListMock);
        accountService.deposit(amount);

        verify(balanceListMock).add(amount);
    }
}
