package com.codurance;

import java.util.List;

public interface StatementFormatter {

    String getHeader();

    List<String> generate(TransactionRecord transactionRecord);

    String formatStatementLine(String transactionDate, int transactionAmount, int transactionBalance);
}
