package com.dmontalvo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/*
There is an integer array nums that consists of n unique elements, but you have forgotten it. However, you do remember
every pair of adjacent elements in nums.
You are given a 2D integer array adjacentPairs of size n - 1 where each adjacentPairs[i] = [ui, vi] 
indicates that the elements ui and vi are adjacent in nums.
It is guaranteed that every adjacent pair of elements nums[i] and nums[i+1] will exist in adjacentPairs, 
either as [nums[i], nums[i+1]] or [nums[i+1], nums[i]]. The pairs can appear in any order.
Return the original array nums. If there are multiple solutions, return any of them.
 */

public class RetoreArrayFromAdjacents {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet();
        List<Integer> result = new ArrayList();

        for (int[] pair : adjacentPairs) {
            graph.putIfAbsent(pair[0],new ArrayList<>());
            graph.putIfAbsent(pair[1],new ArrayList<>());
            graph.get(pair[0]).add(pair[1]);
            graph.get(pair[1]).add(pair[0]);
        }

        int start=0;
        for(int edge:graph.keySet()){
            if(graph.get(edge).size()==1){
                start=edge;
                break;
            }
        }

        deepFirstSearch(result, graph, visited, start);
        
        int[] resultArray=new int[result.size()];
        int i=0;
        for(int a:result){
            resultArray[i]=a;
            i++;
        }
        return resultArray;
        
    }

    void deepFirstSearch(List<Integer> result,Map<Integer,List<Integer>> graph,Set<Integer> visited,int current){
        result.add(current);
        visited.add(current);
        for(int neighboor:graph.get(current)){
            if(!visited.contains(neighboor)){
                deepFirstSearch(result, graph, visited, neighboor);
            }
        }
    }
}