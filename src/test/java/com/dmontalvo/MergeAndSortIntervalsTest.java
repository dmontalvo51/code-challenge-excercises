package com.dmontalvo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class MergeAndSortIntervalsTest {


  @Test
  void testMergeHighDefinitionIntervals_emptyIntervals() {
    assertThat(MergeAndSortIntervals.mergeHighDefinitionIntervals(List.of())).isEmpty();
  }

  @Test
  void testMergeHighDefinitionIntervals_OneInterval() {
    assertThat(MergeAndSortIntervals.mergeHighDefinitionIntervals(List.of(List.of(5, 10))))
        .isEqualTo(List.of(List.of(5, 10)));
  }

  @Test
  void testMergeHighDefinitionIntervals_FourIntervals() {
    assertThat(MergeAndSortIntervals.mergeHighDefinitionIntervals(List.of(List.of(1, 3),
        List.of(2, 6), List.of(8, 10), List.of(15, 18))))
        .isEqualTo(List.of(List.of(1, 6), List.of(8, 10), List.of(15, 18)));
  }

  @Test
  void testMergeHighDefinitionIntervals_FourContinuousIntervals() {
    assertThat(MergeAndSortIntervals.mergeHighDefinitionIntervals(List.of(List.of(1, 3),
        List.of(3, 6), List.of(6, 10), List.of(10, 18))))
        .isEqualTo(List.of(List.of(1, 18)));
  }


  @Test
  void testMergeHighDefinitionIntervals_OneIntervalNegativeValues() {
    assertThat(MergeAndSortIntervals.mergeHighDefinitionIntervals(List.of(List.of(-100, 100))))
        .isEqualTo(List.of(List.of(-100, 100)));
  }

  @Test
  void testMergeHighDefinitionIntervals_FirstIncludeAll() {
    assertThat(MergeAndSortIntervals.mergeHighDefinitionIntervals(List.of(List.of(1, 20),
        List.of(2, 4), List.of(4, 10), List.of(11, 18))))
        .isEqualTo(List.of(List.of(1, 20)));
  }

  @Test
  void testMergeHighDefinitionIntervals_AllSame() {
    assertThat(MergeAndSortIntervals.mergeHighDefinitionIntervals(List.of(List.of(1, 5),
        List.of(1, 5), List.of(1, 5), List.of(1, 5))))
        .isEqualTo(List.of(List.of(1, 5)));
  }

  @Test
  void testMergeHighDefinitionIntervals_NoneOverlaped() {
    assertThat(MergeAndSortIntervals.mergeHighDefinitionIntervals(List.of(List.of(1, 100),
        List.of(101, 200), List.of(201,300))))
        .isEqualTo(List.of(List.of(1, 100), List.of(101, 200), List.of(201,300)));
  }
}
