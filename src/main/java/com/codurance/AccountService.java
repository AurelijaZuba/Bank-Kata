package com.codurance;

public class AccountService {
    private ConsoleWrite consoleMock;

    public AccountService(ConsoleWrite writeline) {

        this.consoleMock = writeline;
    }

    public void deposit(int amount) {
        throw new UnsupportedOperationException();
    }

    public void withdrawal(int amount) {
        throw new UnsupportedOperationException();
    }
}
