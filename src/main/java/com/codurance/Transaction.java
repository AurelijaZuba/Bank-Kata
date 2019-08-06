package com.codurance;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private final LocalDateTime date;
    private final int amount;
    private final int balance;

    public Transaction(LocalDateTime date, int amount, int balance) {
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

    public String formattedDate() {
        return this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public LocalDateTime date() {
        return this.date;
    }
}
