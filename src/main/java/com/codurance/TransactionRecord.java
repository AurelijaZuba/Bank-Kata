package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class TransactionRecord {
    public TransactionRecord(List<Transaction> transactionList) {
        throw new UnsupportedOperationException();
    }

    public TransactionRecord() {
        List<Transaction> transactions = new ArrayList<>();
    }

    public void addDeposit(int amount) {
        throw new UnsupportedOperationException();
    }

    public void addWithdraw(int amount) {
        throw new UnsupportedOperationException();
    }
}
