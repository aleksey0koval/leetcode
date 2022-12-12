package com.kovalchuk.divide_two_integers;

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
                Arguments.of(10, 3, 3),
                Arguments.of(7, -3, -2),
                Arguments.of(-2147483648, -1, 2147483647)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void divide(int dividend, int divisor, int expected) {
        int actual = solution.divide(dividend, divisor);

        assertEquals(expected, actual);
    }
}
