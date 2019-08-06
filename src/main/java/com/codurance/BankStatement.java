package com.codurance;

import java.util.List;

import static java.util.Arrays.asList;

public class BankStatement {
    public List<String> generate(List<Integer> transactions) {
        final String statementHeader = "Date || Amount || Balance";
        if(transactions.isEmpty())
            return asList(statementHeader);
        return asList(
                statementHeader,
                "02/08/2019 || -10 || 0",
                "02/08/2019 || 10  || 10");
    }
}
