package com.codurance;

import java.util.ArrayList;
import java.util.List;

public class PrintableStatement implements StatementFormatter {

    @Override
    public List<String> generate(TransactionRecord transactionRecord) {
        List<String> statementLines = new ArrayList<>();
        statementLines.add(getHeader());
        if(transactionRecord.hasTransactions()) {
            statementLines.addAll(addTransactionsToStatementLines(transactionRecord));
        }

        return statementLines;
    }

    private List<String> addTransactionsToStatementLines(TransactionRecord transactionRecord) {
        List<String> statementLines = new ArrayList<>();
        for (Transaction transaction : transactionRecord.getTransactionsOrderedByDate()) {
            statementLines.add(formatStatementLine(transaction.formattedDate(), transaction.amount(), transaction.balance()));
        }
        return statementLines;
    }

    @Override
    public String getHeader() {
        return "Date || Amount || Balance";
    }

    @Override
    public String formatStatementLine(String transactionDate, int transactionAmount, int transactionBalance) {
        return transactionDate + "\t||\t" + transactionAmount + "\t||\t" + transactionBalance;
    }
}
