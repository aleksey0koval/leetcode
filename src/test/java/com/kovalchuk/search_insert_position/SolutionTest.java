package com.kovalchuk.search_insert_position;

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
                Arguments.arguments(new int[]{1, 3, 5, 6}, 5, 2),
                Arguments.arguments(new int[]{1, 3, 5, 6}, 2, 1),
                Arguments.arguments(new int[]{1, 3, 5, 6}, 7, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void searchInsert(int[] nums, int target, int expected) {
        int actual = solution.searchInsert(nums, target);

        assertEquals(expected, actual);
    }
}
