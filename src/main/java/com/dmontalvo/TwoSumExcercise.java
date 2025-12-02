package com.dmontalvo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */

public class TwoSumExcercise {

    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,List<Integer>> indexes=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            indexes.putIfAbsent(nums[i], new ArrayList<>());
            indexes.get(nums[i]).add(i);
        }

        for(int fixed:indexes.keySet()){
            if(target-fixed==fixed)
                return new int[]{indexes.get(fixed).get(0),indexes.get(fixed).get(1)};
            else if(indexes.containsKey(target-fixed)){
               return new int[]{indexes.get(fixed).get(0),indexes.get(target-fixed).get(0)};
            }
        }
        return new int[]{0,0};
    }
}