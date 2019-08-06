package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private ConsoleWrite console;
    private TransactionRecord transactionRecord;
    private List<Integer> transactions;
    private BankStatement bankStatement;

    public AccountService(ConsoleWrite console, List<Integer> transactions, BankStatement bankStatement) {
        this.console = console;
        this.transactions = transactions;
        this.bankStatement = bankStatement;
    }

    public AccountService(ConsoleWrite console, TransactionRecord transactionRecord, BankStatement bankStatement) {
        this.console = console;
        this.transactionRecord = transactionRecord;
        this.bankStatement = bankStatement;
    }

    public void deposit(int amount) {
        transactions.add(amount);
    }

    public void deposit1(int amount) {
        transactionRecord.addDeposit(amount);
    }

    public void withdraw(int amount) {
        transactions.add(-amount);
    }

    public void printStatement() {
        List<String> statementLines = bankStatement.generate(transactions);

        System.out.println(statementLines);
        for (String line : statementLines) {
            console.print(line);
        }
    }

    public void withdraw1(int amount) {
        new UnsupportedOperationException();
    }
}
