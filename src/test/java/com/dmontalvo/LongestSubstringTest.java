package com.dmontalvo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestSubstringTest {

    private final LongestSubstring solution = new LongestSubstring();

    @Test
    void lengthOfLongestSubstring_handlesDistinctAndRepeatedChars() {
        assertThat(solution.lengthOfLongestSubstring("au")).isEqualTo(2);
        assertThat(solution.lengthOfLongestSubstring("abcabcbb")).isEqualTo(3);
        assertThat(solution.lengthOfLongestSubstring("bbbbb")).isEqualTo(1);
        assertThat(solution.lengthOfLongestSubstring("pwwkew")).isEqualTo(3);
    }
}
