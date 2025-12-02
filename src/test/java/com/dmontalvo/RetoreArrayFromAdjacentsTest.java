package com.dmontalvo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RetoreArrayFromAdjacentsTest {

    private final RetoreArrayFromAdjacents solution = new RetoreArrayFromAdjacents();

    @Test
    void restoreArray_reconstructsSequenceFromPairs() {
        assertThat(solution.restoreArray(new int[][]{{2, 1}, {3,4}, {3,2}})).isEqualTo(new int[]{1,2,3,4});
        assertThat(solution.restoreArray(new int[][]{{4,-2}, {1,4}, {-3,1}})).isEqualTo(new int[]{-2,4,1,-3});
        assertThat(solution.restoreArray(new int[][]{{10000,-10000}})).isEqualTo(new int[]{10000,-10000});
    }


}
