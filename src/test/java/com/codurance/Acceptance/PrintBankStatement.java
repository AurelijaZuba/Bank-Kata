package com.codurance.Acceptance;

import com.codurance.AccountService;
import com.codurance.BankStatement;
import com.codurance.ConsoleWrite;
import com.codurance.TransactionRecord;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PrintBankStatement {


    @Test
    void AcceptanceTest() {
        ConsoleWrite consoleMock = mock(ConsoleWrite.class);
        List<Integer> transactions = new ArrayList<>();
        BankStatement bankStatement = new BankStatement();

        AccountService accountService = new AccountService(consoleMock, transactions, bankStatement);
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


    @Test
    void AcceptanceTest1() {
        ConsoleWrite consoleMock = mock(ConsoleWrite.class);
        BankStatement bankStatement = new BankStatement();

        TransactionRecord transactionRecord = new TransactionRecord();
        AccountService accountService = new AccountService(consoleMock, transactionRecord, bankStatement);
        accountService.deposit1(1000);
        accountService.deposit1(2000);
        accountService.withdraw1(500);
        accountService.printStatement1();


        InOrder inOrder = inOrder(consoleMock);
        inOrder.verify(consoleMock).print("Date || Amount || Balance");
        inOrder.verify(consoleMock).print("14/01/2012 || -500   || 2500");
        inOrder.verify(consoleMock).print("13/01/2012 || 2000   || 3000");
        inOrder.verify(consoleMock).print("10/01/2012 || 1000   || 1000");

    }
}
