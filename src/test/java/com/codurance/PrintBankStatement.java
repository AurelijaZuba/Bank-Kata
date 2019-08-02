package com.codurance;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class PrintBankStatement {


    @Test
    void AcceptanceTest() {
        ConsoleWrite consoleMock = mock(ConsoleWrite.class);

        AccountService accountService = new AccountService(consoleMock);
        accountService.deposit(1000);
        accountService.deposit(2000);
        accountService.withdrawal(500);


        InOrder inOrder = inOrder(consoleMock);
        inOrder.verify(consoleMock).print("Date || Amount || Balance");
        inOrder.verify(consoleMock).print("14/01/2012 || -500   || 2500");
        inOrder.verify(consoleMock).print("13/01/2012 || 2000   || 3000");
        inOrder.verify(consoleMock).print("10/01/2012 || 1000   || 1000");

    }
}
