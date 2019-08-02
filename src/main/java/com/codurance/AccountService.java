package com.codurance;

import java.util.List;

public class AccountService {
    private ConsoleWrite consoleMock;
    private List<Integer> balanceList;

    public AccountService(ConsoleWrite writeline, List<Integer> balanceList) {

        this.consoleMock = writeline;
        this.balanceList = balanceList;
    }

    public void deposit(int amount) {
        throw new UnsupportedOperationException();
    }

    public void withdrawal(int amount) {
        throw new UnsupportedOperationException();
    }
}
