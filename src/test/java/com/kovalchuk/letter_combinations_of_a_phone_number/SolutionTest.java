package com.kovalchuk.letter_combinations_of_a_phone_number;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
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
                Arguments.of("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                Arguments.of("", List.of()),
                Arguments.of("2", List.of("a", "b", "c"))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void letterCombinations(String input, List<String> expected) {
        List<String> actual = solution.letterCombinations(input);

        assertEquals(expected, actual);
    }
}
