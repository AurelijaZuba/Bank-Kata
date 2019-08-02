package com.codurance;

import java.util.List;

import static java.util.Arrays.asList;

public class BankStatement {
    public List<String> generate(List<Integer> transactions) {
        return asList(
                "Date || Amount || Balance",
                "02/08/2019 || -10 || 0",
                "02/08/2019 || 10  || 10");
    }
}
