package com.codurance;

import java.util.List;

public class AccountService {
    private ConsoleWrite console;
    private TransactionRecord transactionRecord;
    private BankStatement bankStatement;

    public AccountService(ConsoleWrite console, TransactionRecord transactionRecord, BankStatement bankStatement) {
        this.console = console;
        this.transactionRecord = transactionRecord;
        this.bankStatement = bankStatement;
    }

    public void deposit(int amount) {
        transactionRecord.addDeposit(amount);
    }

    public void withdraw(int amount) {
        this.transactionRecord.addWithdraw(amount);
    }

    public void printStatement() {
        List<String> statementLines = bankStatement.generate(transactionRecord);

        for (String line : statementLines) {
            System.out.println(line);
            console.print(line);
        }
    }
}
