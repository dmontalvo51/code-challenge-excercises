package com.dmontalvo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AddTwoNumbersTest {

    private final AddTwoNumbers solution = new AddTwoNumbers();

    @Test
    void addTwoNumbers_handlesListsOfDiferentLength() {
      ListNode result=solution.addTwoNumbers(new ListNode(List.of(9,9,9,9,9,9,9)), new ListNode(List.of(9,9,9,9)));
      List<Integer> expected=List.of(8,9,9,9,0,0,0,1);
      Assertions.assertThat(result.toList()).containsAll(expected);
    }

    @Test
    void addTwoNumbers_emptyLists() {
      ListNode result=solution.addTwoNumbers(new ListNode(), new ListNode());
      Assertions.assertThat(result.toList()).isEqualTo(List.of(0));

    }
}
