package com.dmontalvo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TransactionsExcerciseTest {

    @Test
    void testRegisterTransactions() {
        TransactionsExcercise solution=new TransactionsExcercise();
        solution.registerTransactions(new String[]{"1000,50,2000","1000,150,3000","2000,400,1000","2000,50,3000","3000,300,2000"});
        assertThat(solution.getBalances().get(1000)).isEqualTo(200);
        assertThat(solution.getBalances().get(2000)).isEqualTo(-100);
        assertThat(solution.getBalances().get(3000)).isEqualTo(-100);
    }
}
