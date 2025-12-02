package com.dmontalvo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumExcerciseTest {
    private final TwoSumExcercise solution = new TwoSumExcercise();

    @Test
    void twoSum_returnsIndexesThatHitTheTarget() {
      assertThat(solution.twoSum(new int[]{2,7,11,15},9)).isEqualTo(new int[]{0,1});
      assertThat(solution.twoSum(new int[]{3,2,4},6)).isEqualTo(new int[]{1,2});
      assertThat(solution.twoSum(new int[]{3,3},6)).isEqualTo(new int[]{0,1});
    }
}
