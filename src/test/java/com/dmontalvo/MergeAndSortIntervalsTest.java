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
        assertThat(MergeAndSortIntervals.mergeHighDefinitionIntervals(List.of(List.of(5,10))))
        .isEqualTo(List.of(List.of(5,10)));
    }

        @Test
    void testMergeHighDefinitionIntervals_FourIntervals() {
        assertThat(MergeAndSortIntervals.mergeHighDefinitionIntervals(List.of(List.of(1,3),
    List.of(2,6),List.of(8,10),List.of(15,18))))
        .isEqualTo(List.of(List.of(1,6),List.of(8,10),List.of(15,18)));
    }

            @Test
    void testMergeHighDefinitionIntervals_OneIntervalNegativeValues() {
        assertThat(MergeAndSortIntervals.mergeHighDefinitionIntervals(List.of(List.of(-100,100))))
        .isEqualTo(List.of(List.of(-100,100)));
    }
}
