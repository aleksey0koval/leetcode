package com.kovalchuk.remove_element;

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
                Arguments.of(new int[]{3, 2, 2, 3}, 3, 2),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void removeElement(int[] nums, int val, int expected) {
        int actual = solution.removeElement(nums, val);

        assertEquals(expected, actual);
    }
}
