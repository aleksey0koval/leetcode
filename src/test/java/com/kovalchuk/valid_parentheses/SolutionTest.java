package com.kovalchuk.valid_parentheses;

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
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("{[]}", true),
                Arguments.of("(]", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void isValid(String s, boolean expected) {
        boolean actual = solution.isValid(s);

        assertEquals(expected, actual);
    }
}
