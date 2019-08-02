package com.codurance;

import java.util.List;

public class AccountService {
    private ConsoleWrite consoleMock;
    private List<Integer> transactions;
    private BankStatement bankStatement;

    public AccountService(ConsoleWrite writeline, List<Integer> transactions, BankStatement bankStatement) {
        this.consoleMock = writeline;
        this.transactions = transactions;
        this.bankStatement = bankStatement;
    }

    public void deposit(int amount) {
        transactions.add(amount);
    }

    public void withdraw(int amount) {
        transactions.add(-amount);
    }

    public void printStatement() {
        bankStatement.generate(transactions);
    }
}
