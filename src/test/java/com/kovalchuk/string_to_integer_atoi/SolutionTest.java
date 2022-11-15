package com.kovalchuk.string_to_integer_atoi;

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
                Arguments.of("42", 42),
                Arguments.of("   -42", -42),
                Arguments.of("   -000042", -42),
                Arguments.of("4193 with words", 4193),
                Arguments.of("words and 987", 0),
                Arguments.of("-91283472332", -2147483648),
                Arguments.of("2147483648", 2147483647),
                Arguments.of("3.14159", 3),
                Arguments.of("-+12", 0),
                Arguments.of("", 0),
                Arguments.of("-", 0),
                Arguments.of("+1", 1),
                Arguments.of(null, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void testMyAtoi(String input, int expected) {
        int actual = solution.myAtoi(input);

        assertEquals(expected, actual);
    }
}