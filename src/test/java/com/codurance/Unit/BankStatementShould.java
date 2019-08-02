package com.codurance.Unit;

import com.codurance.BankStatement;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class BankStatementShould {
    @Test
    void generate_a_statement() {
        BankStatement bankStatement = new BankStatement();
        List<Integer> transactions = asList(10, -10);

        List<String> expectedStatement = asList(
                "Date || Amount || Balance",
                "02/08/2019 || -10 || 0",
                "02/08/2019 || 10  || 10"
        );

        List<String> printableStatement = bankStatement.generate(transactions);


        assertThat(printableStatement).isEqualTo(expectedStatement);
    }
}
