package com.codurance;

public class Transaction {

    private final String date;
    private final int amount;
    private final int balance;

    public Transaction(String date, int amount, int balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public int amount() {
        return this.amount;
    }

    public int balance() {
        return this.balance;
    }

    public String date() {
        return this.date;
    }
}
