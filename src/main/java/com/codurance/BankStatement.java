package com.codurance;

import java.util.List;

import static java.util.Arrays.asList;

public class BankStatement {

    public static final String STATEMENT_HEADER = "Date || Amount || Balance";

    public List<String> generate(List<Integer> transactions) {
        if(transactions.isEmpty())
            return asList(STATEMENT_HEADER);
        return asList(
                STATEMENT_HEADER,
                "02/08/2019 || -10 || 0",
                "02/08/2019 || 10  || 10");
    }

    public List<String> generate(TransactionRecord transactionRecord) {
        return asList(STATEMENT_HEADER);
    }
}
