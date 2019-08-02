package com.codurance.Unit;

import com.codurance.BankStatement;
import com.codurance.PrintableStatement;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class BankStatementShould {
    @Test
    void generate_a_statement() {
        BankStatement bankStatement = new BankStatement();
        List<Integer> transactions = asList(10, -10);

        PrintableStatement expectedStatement = new PrintableStatement();
        expectedStatement.addTransaction(10);
        expectedStatement.addTransaction(-10);

        PrintableStatement actualStatment = bankStatement.generate(transactions);


        assertThat(actualStatment).isEqualTo(expectedStatement);
    }
}
