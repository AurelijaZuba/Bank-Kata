package com.codurance;

import java.util.*;

public class TransactionRecord implements Iterable<Transaction>{
    private final List<Transaction> transactions;
    private int balance;

    public TransactionRecord(List<Transaction> transactionList) {
        this.transactions = transactionList;
        balance = 0;
    }

    public TransactionRecord() {
        this.transactions = new ArrayList<>();
        balance = 0;
    }

    public void addDeposit(int amount) {
        updateBalance(amount);
        transactions.add(new Transaction("02/08/2019", amount, balance));
    }

    public void addWithdraw(int amount) {
        transactions.add(new Transaction("02/08/2019", 20, 0));
    }

    public boolean hasTransactions() {
        return !transactions.isEmpty();
    }

    private void updateBalance(int amount) {
        balance += amount;
    }
    @Override
    public Iterator iterator() {
        return this.transactions.iterator();
    }
}
