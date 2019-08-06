package com.codurance;

import java.util.*;

public class TransactionRecord implements Iterable<Transaction>{
    private final List<Transaction> transactions;
    private LocalClock clock;
    private int balance;

    public TransactionRecord(List<Transaction> transactionList, LocalClock clock) {
        this.transactions = transactionList;
        this.clock = clock;
        balance = 0;
    }

    public TransactionRecord() {
        this.transactions = new ArrayList<>();
        balance = 0;
    }

    public void addDeposit(int amount) {
        updateBalance(amount);
        transactions.add(new Transaction(clock.now(), amount, balance));
    }

    public void addWithdraw(int amount) {
        updateBalance(-amount);
        transactions.add(new Transaction(clock.now(), -amount, balance));
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

    public List<Transaction> getTransactionsOrderedByDate() {
        List<Transaction> orderedList = new ArrayList<>();


        for (int i = transactions.size()-1; i >= 0; i--) {
            orderedList.add(transactions.get(i));
        }

        return orderedList;
    }
}
