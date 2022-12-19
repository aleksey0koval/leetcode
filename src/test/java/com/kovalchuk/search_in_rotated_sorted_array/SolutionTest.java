package com.kovalchuk.search_in_rotated_sorted_array;

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
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                Arguments.of(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                Arguments.of(new int[]{5, 1, 3}, 5, 0),
                Arguments.of(new int[]{1}, 0, -1)
        );
    }


    @ParameterizedTest
    @MethodSource("testData")
    void search(int[] nums, int target, int expected) {
        int actual = solution.search(nums, target);

        assertEquals(expected, actual);
    }
}
