package com.kovalchuk.longest_common_prefix;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SolutionTest {
    private Solution solution;

    @BeforeAll
    public void init() {
        solution = new Solution();
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of(new String[]{}, ""),
                Arguments.of(new String[]{"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[]{"dog", "racecar", "car"}, ""),
                Arguments.of(new String[]{"ab", "a"}, "a"),
                Arguments.of(new String[]{"abc"}, "abc")
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void longestCommonPrefix(String[] input, String expected) {
        String actual = solution.longestCommonPrefix(input);

        assertEquals(expected, actual);
    }
}
