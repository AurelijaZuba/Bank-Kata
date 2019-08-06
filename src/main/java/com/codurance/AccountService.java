package com.codurance;

import java.util.List;

public class AccountService {
    private ConsoleWrite console;
    private TransactionRecord transactionRecord;
    private StatementFormatter statementFormatter;

    public AccountService(ConsoleWrite console, TransactionRecord transactionRecord, StatementFormatter statementFormatter) {
        this.console = console;
        this.transactionRecord = transactionRecord;
        this.statementFormatter = statementFormatter;
    }

    public void deposit(int amount) {
        transactionRecord.addDeposit(amount);
    }

    public void withdraw(int amount) {
        this.transactionRecord.addWithdraw(amount);
    }

    public void printStatement() {
        List<String> statementLines = statementFormatter.generate(transactionRecord);

        for (String line : statementLines) {
            console.print(line);
        }
    }
}
