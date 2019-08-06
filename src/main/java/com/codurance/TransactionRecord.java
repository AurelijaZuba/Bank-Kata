package com.codurance;

import java.util.*;

public class TransactionRecord implements Iterable<Transaction>{
    private final List<Transaction> transactions;

    public TransactionRecord(List<Transaction> transactionList) {
        this.transactions = transactionList;
    }

    public TransactionRecord() {
        this.transactions = new ArrayList<>();
    }

    public void addDeposit(int amount) {
        transactions.add(new Transaction("02/08/2019", amount, 0));
    }

    public void addWithdraw(int amount) {
        transactions.add(new Transaction("02/08/2019", 20, amount));
    }

    public boolean hasTransactions() {
        return !transactions.isEmpty();
    }

    @Override
    public Iterator iterator() {
        return this.transactions.iterator();
    }
}
