package com.kovalchuk.roman_to_integer;

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
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994),
                Arguments.of("MMMMMMMMMMMCMXCIII", 11993)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void intToRoman(String input, int expected) {
        int actual = solution.romanToInt(input);

        assertEquals(expected, actual);
    }
}
