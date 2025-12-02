package com.dmontalvo;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EmployeeInfoExcerciseTest {

    @Test
    void test_employeeInfo_adjacencyMap() {
      EmployeeInfoExcercise exercise = new EmployeeInfoExcercise();
      exercise.init(new String[] {"1000, john, engineering", "2000, mathew, accounting", "3000, mary, hr"},
          new String[] {"1000,3000", "2000,1000"});
      assertThat(exercise.getAdjancencyMap()).contains("1000:[2000,3000]")
          .contains("2000:[1000]").contains("3000:[1000]");
      assertThat(exercise.getEmployeeAdjacency("john")).contains("mathew").contains("mary");
    }

  @Test
  void test_employeeInfo_noAdjacencyMap() {
    EmployeeInfoExcercise exercise = new EmployeeInfoExcercise();
    exercise.init(new String[] {"1000, john, engineering", "2000, mathew, accounting", "3000, mary, hr"},
        new String[] {});
    assertThat(exercise.getAdjancencyMap()).isEqualTo("[]");
    assertThat(exercise.getEmployeeAdjacency("john")).isEqualTo("john is adjacent to ");
  }
}
