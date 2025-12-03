package com.dmontalvo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MergeSortedArraysTest {

  private final MergeSortedArrays solution = new MergeSortedArrays();

  @Test
  void testMergeArrays_combinesSortedInputs() {
    assertThat(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}))
        .isEqualTo(2.0d);
  }


  @Test
  void testMergeArrays_combinesSortedInputs2() {
    assertThat(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3,4}))
        .isEqualTo(2.5d);
  }


  @Test
  void testMergeArrays_combinesSortedEqualOddInputs() {
    assertThat(solution.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{1, 2, 3}))
        .isEqualTo(2.0d);
  }

  @Test
  void testMergeArrays_combinesSortedEqualEvenInputs() {
    assertThat(solution.findMedianSortedArrays(new int[]{2, 4, 6, 8},
        new int[]{2, 4, 6, 8})).isEqualTo(5.0d);
  }

  @Test
  void testMergeArrays_combinesSortedDifferentInputsRightBigger() {
    assertThat(solution.findMedianSortedArrays(new int[]{1, 5, 10, 12},
        new int[]{2, 5, 8, 11, 12, 15}))
        .isEqualTo(8.0d); // [1,2,5,8,10,11,12,15] media 9
  }

  void testMergeArrays_combinesSortedDifferentInputsLeftBigger() {
    assertThat(solution.findMedianSortedArrays(new int[]{3, 6, 8, 12},
        new int[]{2, 3, 8})).isEqualTo(6.2d);
  }
}
