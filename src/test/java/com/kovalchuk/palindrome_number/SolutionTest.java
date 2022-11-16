package com.kovalchuk.palindrome_number;

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
                Arguments.of(0, true),
                Arguments.of(1, true),
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false),
                Arguments.of(11, true),
                Arguments.of(12, false),
                Arguments.of(1221, true),
                Arguments.of(1222, false),
                Arguments.of(12321, true),
                Arguments.of(12331, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void isPalindrome(int input, boolean expected) {
        boolean actual = solution.isPalindrome(input);

        assertEquals(expected, actual);
    }
}
