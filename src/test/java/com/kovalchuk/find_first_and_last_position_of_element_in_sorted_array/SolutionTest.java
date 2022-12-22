package com.kovalchuk.find_first_and_last_position_of_element_in_sorted_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SolutionTest {
    private Solution solution;

    @BeforeEach
    public void init() {
        solution = new Solution();
    }

    static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                Arguments.of(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
                Arguments.of(new int[]{}, 0, new int[]{-1, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void searchRange(int[] nums, int target, int[] expected) {
        int[] actual = solution.searchRange(nums, target);

        assertArrayEquals(expected, actual);
    }
}