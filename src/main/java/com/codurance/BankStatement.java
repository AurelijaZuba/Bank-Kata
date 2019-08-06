package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class BankStatement {

    public static final String STATEMENT_HEADER = "Date || Amount || Balance";

    public List<String> generate(TransactionRecord transactionRecord) {
        List<String> statementLines = new ArrayList<>();
        statementLines.add(STATEMENT_HEADER);
        if(transactionRecord.hasTransactions())
            for (Transaction transaction : transactionRecord) {
                statementLines.add(formatStatementLine(transaction.date(), transaction.amount(), transaction.balance()));
            }

        return statementLines;
    }

    private String formatStatementLine(String transactionDate, int transactionAmount, int transactionBalance) {
        return transactionDate + "\t||\t" + transactionAmount + "\t||\t" + transactionBalance;
    }
}
