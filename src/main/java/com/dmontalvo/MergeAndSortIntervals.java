package com.dmontalvo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Diego Montalvo on 12/3/25
 *
 *         Given an array of intervals [startTime, endTime], merge all
 *         overlapping intervals and return a sorted array of non-overlapping
 *         intervals.
 *         Example
 *         Input
 *         intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
 *         Output
 *         [[1, 6], [8, 10], [15, 18]]
 *         Explanation
 *
 *         Step 1: Sort intervals by start time (already sorted).
 *         Step 2: Initialize merged list with first interval [1,3].
 *         Step 3: Compare [2,6] with last merged [1,3]. They overlap (2 ≤ 3),
 *         so merge into [1,6].
 *         Step 4: Compare [8,10] with last merged [1,6]. No overlap (8 > 6),
 *         append [8,10].
 *         Step 5: Compare [15,18] with last merged [8,10]. No overlap (15 >
 *         10), append [15,18].
 *
 *         Result: [[1,6],[8,10],[15,18]].
 *
 */
public class MergeAndSortIntervals {

  public static List<List<Integer>> mergeHighDefinitionIntervals(List<List<Integer>> intervals) {
      List<List<Integer>>  result= new ArrayList<>();
      if(intervals.isEmpty())return result;
      result.add(intervals.get(0));


      for(int i=1;i<intervals.size();i++){
          int lastresult=result.size()-1;
          if(overlap(result.get(lastresult),intervals.get(i))){
            result.set(lastresult, merge(result.get(lastresult),intervals.get(i)));
          }else{
            result.add(intervals.get(i));
          }
      }

      return result;

  }

  private static boolean overlap(List<Integer> left, List<Integer> right) {
    return right.get(0) <= left.get(1);
  }

  private static List<Integer> merge(List<Integer> left, List<Integer> right) {
    int start = left.get(0);
    int end;
    if (right.get(1) <= left.get(1))
      end = left.get(1);
    else
      end = right.get(1);

    return List.of(start, end);
  }
}
