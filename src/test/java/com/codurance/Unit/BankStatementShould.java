package com.codurance.Unit;

import com.codurance.BankStatement;
import com.codurance.TransactionRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

public class BankStatementShould {

    @Test
    void generate_statement_header() {
        BankStatement bankStatement = new BankStatement();
        TransactionRecord transactions = new TransactionRecord();

        List<String> expectedStatement = asList(
                "Date || Amount || Balance"
        );

        List<String> printableStatement = bankStatement.generate(transactions);

        assertThat(printableStatement).isEqualTo(expectedStatement);
    }

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

    @Test
    void generate_a_statement1() {
        BankStatement bankStatement = new BankStatement();
        TransactionRecord transactions = new TransactionRecord();
        transactions.addDeposit(10);
        transactions.addWithdraw(10);

        List<String> expectedStatement = asList(
                "Date || Amount || Balance",
                "02/08/2019 || -10 || 0",
                "02/08/2019 || 10  || 10"
        );

        List<String> printableStatement = bankStatement.generate(transactions);

        assertThat(printableStatement).isEqualTo(expectedStatement);
    }
}
