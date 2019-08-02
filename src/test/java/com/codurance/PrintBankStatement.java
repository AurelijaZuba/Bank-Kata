package com.codurance;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PrintBankStatement {


    @Test
    void AcceptanceTest() {
        ConsoleWrite consoleMock = mock(ConsoleWrite.class);
        List<Integer> balance = new ArrayList<>();
        BankStatement bankStatement = new BankStatement();

        AccountService accountService = new AccountService(consoleMock, balance, bankStatement);
        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.withdraw(500);
        accountService.printStatement();


        InOrder inOrder = inOrder(consoleMock);
        inOrder.verify(consoleMock).print("Date || Amount || Balance");
        inOrder.verify(consoleMock).print("14/01/2012 || -500   || 2500");
        inOrder.verify(consoleMock).print("13/01/2012 || 2000   || 3000");
        inOrder.verify(consoleMock).print("10/01/2012 || 1000   || 1000");

    }
}
