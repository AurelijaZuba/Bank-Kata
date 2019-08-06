package com.codurance.Unit;

import com.codurance.PrintableStatement;
import com.codurance.StatementFormatter;
import com.codurance.Transaction;
import com.codurance.TransactionRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PrintableStatementShould {

    private TransactionRecord transactionsMock;
    private LocalDateTime dateTime1;

    @BeforeEach
    void setUp() {
        transactionsMock = mock(TransactionRecord.class);
        dateTime1 = LocalDateTime.of(2019, Month.AUGUST, 02, 15, 19);
    }

    @Test
    void generate_statement_header() {
        StatementFormatter statementFormatter = new PrintableStatement();
        TransactionRecord transactions = new TransactionRecord();

        List<String> expectedStatement = asList("Date || Amount || Balance");

        List<String> statementLines = statementFormatter.generate(transactions);

        assertThat(statementLines).isEqualTo(expectedStatement);
    }

    @Test
    void generate_a_statement_with_two_transactions() {
        StatementFormatter statementFormatter = new PrintableStatement();

        Transaction transaction1 = new Transaction(dateTime1, 10, 10);
        Transaction transaction2 = new Transaction(dateTime1.plusMinutes(1), -10, 0);
        List<Transaction> transactionList = asList(transaction2, transaction1);

        when(transactionsMock.getTransactionsOrderedByDate()).thenReturn(transactionList);
        when(transactionsMock.hasTransactions()).thenReturn(true);

        List<String> expectedStatement = asList(
                "Date || Amount || Balance",
                "02/08/2019\t||\t-10\t||\t0",
                "02/08/2019\t||\t10\t||\t10"
        );

        List<String> statementLines = statementFormatter.generate(transactionsMock);

        assertThat(statementLines).isEqualTo(expectedStatement);
    }

    @Test
    void generate_a_statement_with_three_transactions() {
        StatementFormatter statementFormatter = new PrintableStatement();

        Transaction transaction1 = new Transaction(dateTime1, 20, 20);
        Transaction transaction2 = new Transaction(dateTime1.plusMinutes(1), -10, 10);
        Transaction transaction3 = new Transaction(dateTime1.plusMinutes(2), -10, 0);
        List<Transaction> transactionList = asList(transaction3, transaction2, transaction1);

        when(transactionsMock.getTransactionsOrderedByDate()).thenReturn(transactionList);
        when(transactionsMock.hasTransactions()).thenReturn(true);

        List<String> expectedStatement = asList(
                "Date || Amount || Balance",
                "02/08/2019\t||\t-10\t||\t0",
                "02/08/2019\t||\t-10\t||\t10",
                "02/08/2019\t||\t20\t||\t20"
        );

        List<String> statementLines = statementFormatter.generate(transactionsMock);

        assertThat(statementLines).isEqualTo(expectedStatement);
    }

}
