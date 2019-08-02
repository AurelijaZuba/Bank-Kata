package com.codurance;

import java.util.List;

public class AccountService {
    private ConsoleWrite consoleMock;
    private List<Integer> balanceList;
    private BankStatement bankStatement;

    public AccountService(ConsoleWrite writeline, List<Integer> balanceList, BankStatement bankStatement) {
        this.consoleMock = writeline;
        this.balanceList = balanceList;
        this.bankStatement = bankStatement;
    }

    public void deposit(int amount) {
        balanceList.add(amount);
    }

    public void withdraw(int amount) {
        balanceList.add(-amount);
    }

    public void printStatement() {
        bankStatement.generate(balanceList);
    }
}
