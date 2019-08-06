package com.codurance.Unit;

import com.codurance.BankStatement;
import com.codurance.Transaction;
import com.codurance.TransactionRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Iterator;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankStatementShould {

    private TransactionRecord transactionsMock;
    private LocalDateTime dateTime1;

    @BeforeEach
    void setUp() {
        transactionsMock = mock(TransactionRecord.class);
        dateTime1 = LocalDateTime.of(2019, Month.AUGUST, 02, 15, 19);
    }

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
    void generate_a_statement_with_two_transactions() {
        BankStatement bankStatement = new BankStatement();

        TransactionRecord transactionsMock = mock(TransactionRecord.class);

        Transaction transaction1 = new Transaction(dateTime1, 10, 10);
        Transaction transaction2 = new Transaction(dateTime1.plusMinutes(1), -10, 0);
        List<Transaction> mockTransactions = asList(transaction2, transaction1);
        when(transactionsMock.iterator()).thenReturn(mockTransactions.iterator());
        when(transactionsMock.hasTransactions()).thenReturn(true);

        List<String> expectedStatement = asList(
                "Date || Amount || Balance",
                "02/08/2019\t||\t-10\t||\t0",
                "02/08/2019\t||\t10\t||\t10"
        );

        List<String> printableStatement = bankStatement.generate(transactionsMock);

        assertThat(printableStatement).isEqualTo(expectedStatement);
    }

    @Test
    void generate_a_statement_with_three_transactions() {
        BankStatement bankStatement = new BankStatement();

        Transaction transaction1 = new Transaction(dateTime1, 20, 20);
        Transaction transaction2 = new Transaction(dateTime1.plusMinutes(1), -10, 10);
        Transaction transaction3 = new Transaction(dateTime1.plusMinutes(2), -10, 0);
        List<Transaction> mockTransactions = asList(transaction1, transaction2, transaction3);
        when(transactionsMock.iterator()).thenReturn(mockTransactions.iterator());
        when(transactionsMock.hasTransactions()).thenReturn(true);

        List<String> expectedStatement = asList(
                "Date || Amount || Balance",
                "02/08/2019\t||\t-10\t||\t0",
                "02/08/2019\t||\t-10\t||\t10",
                "02/08/2019\t||\t20\t||\t20"
        );

        List<String> printableStatement = bankStatement.generate(transactionsMock);

        assertThat(printableStatement).isEqualTo(expectedStatement);
    }

}
