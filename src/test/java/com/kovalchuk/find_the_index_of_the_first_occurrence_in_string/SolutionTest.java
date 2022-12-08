package com.kovalchuk.find_the_index_of_the_first_occurrence_in_string;

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
                Arguments.of("sadbutsad", "sad", 0),
                Arguments.of("a", "a", 0),
                Arguments.of("leetcode", "leeto", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void strStr(String haystack, String needle, int expected) {
        int actual = solution.strStr(haystack, needle);

        assertEquals(expected, actual);
    }
}
