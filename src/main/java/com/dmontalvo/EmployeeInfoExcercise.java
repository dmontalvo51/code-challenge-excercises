package com.dmontalvo;

import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*

Array of employee info ["1000, john, engineering", "2000, mathew, accounting", "3000, mary, hr", ...] 
& another array of adjancency, where it indicates who is friends with who within the company: 
["1000, 3000", "2000, 1000", ...] 

return an output that indicates the adjacency map such as 
[ 1000: [3000, 2000], 2000: [1000] ] 

and a follow up question like "given the name of an employee, return the list of their friends name" 
input: "john" 
expected output: "john is adjacent to mathew, mary"
 */

public class EmployeeInfoExcercise {

  private Map<Integer, List<Integer>> graph = new HashMap<>();
  private Map<Integer, String> employeeAreas; // Not necessary
  private Map<String, Integer> employeeNames = new HashMap<>();
  private Map<Integer, String> employeeIds = new HashMap<>();

  public void init(String[] employeeInfo, String[] adjacency) {
    for (String employee : employeeInfo) {
      String[] data = employee.split(",");
      employeeNames.put(data[1].strip(), Integer.valueOf(data[0]));
      employeeIds.put(Integer.valueOf(data[0]), data[1].strip());
    }
    for (String pair : adjacency) {
      String[] friends = pair.split(",");
      graph.putIfAbsent(Integer.valueOf(friends[0]), new ArrayList<>());
      graph.putIfAbsent(Integer.valueOf(friends[1]), new ArrayList<>());
      graph.get(Integer.valueOf(friends[0])).add(Integer.valueOf(friends[1]));
      graph.get(Integer.valueOf(friends[1])).add(Integer.valueOf(friends[0]));
    }
  }

  public String getAdjancencyMap() {
    return graph.entrySet().stream()
        .map(entry -> "%d:[%s]".formatted(entry.getKey(),
            entry.getValue().stream().sorted().map(String::valueOf).collect(
                Collectors.joining(","))))
        .collect(joining(",", "[", "]"));
  }

  public String getEmployeeAdjacency(String employeeName) {
    String neighboors;
    Integer employeeId=employeeNames.get(employeeName.strip());
    if(employeeId==null || !graph.containsKey(employeeId))
      neighboors="";
    else{
      neighboors= graph.get(employeeId).stream().map(id -> employeeIds.get(id))
          .collect(joining(","));
    }
    return "%s is adjacent to %s".formatted(employeeName.strip(),neighboors);
  }

}
