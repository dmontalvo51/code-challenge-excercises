package com.dmontalvo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MergeSortedArraysTest {

   private final MergeSortedArrays solution=new MergeSortedArrays();

    @Test
    void testMergeArrays_combinesSortedEqualOddInputs() {
      var result=solution.mergeArrays(new int[]{1,2,3},new int[]{1,2,3}); //iguales, media 2
      assertThat(result).containsExactly(1,2,3);
      assertThat(solution.median(result)).isEqualTo(2.0d);
    }

    @Test
    void testMergeArrays_combinesSortedEqualEvenInputs() {
      var result=solution.mergeArrays(new int[]{2,4,6,8},new int[]{2,4,6,8}); //iguales, media 2
      assertThat(result).containsExactly(2,4,6,8);
      assertThat(solution.median(result)).isEqualTo(5.0d);
    }

  @Test
  void testMergeArrays_combinesSortedDifferentInputsRightBigger() {
    var result=solution.mergeArrays(new int[]{1,5,10,12},new int[]{2,5,8,11,12,15}); // [1,2,5,8,10,11,12,15] media 9
    assertThat(result).containsExactly(1,2,5,8,10,11,12,15);
    assertThat(solution.median(result)).isEqualTo(9.0d);

  }

  void testMergeArrays_combinesSortedDifferentInputsLeftBigger() {
    var result = solution.mergeArrays(new int[]{3, 6, 8, 12},
        new int[]{2, 3, 8}); // [2,3,6,8,12] media 6
    assertThat(result).containsExactly(2,3,6,8,12);
    assertThat(solution.median(result)).isEqualTo(6.0d);

  }
}
