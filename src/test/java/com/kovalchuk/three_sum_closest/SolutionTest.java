package com.kovalchuk.three_sum_closest;

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
                Arguments.of(new int[]{-1, 2, 1, -4}, 1, 2),
                Arguments.of(new int[]{0, 0, 0}, 1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void threeSumClosest(int[] nums, int target, int expected) {
        int actual = solution.threeSumClosest(nums, target);

        assertEquals(expected, actual);
    }
}
