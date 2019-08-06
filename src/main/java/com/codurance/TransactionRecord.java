package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class TransactionRecord {
    private final List<Transaction> transactions;

    public TransactionRecord(List<Transaction> transactionList) {
        this.transactions = transactionList;
    }

    public TransactionRecord() {
        this.transactions = new ArrayList<>();
    }

    public void addDeposit(int amount) {
        transactions.add(new Transaction(amount));
    }

    public void addWithdraw(int amount) {
        transactions.add(new Transaction(amount));
    }
}
