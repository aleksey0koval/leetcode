package com.kovalchuk.four_sum;

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
                Arguments.of(new int[]{1, 0, -1, 0, -2, 2}, 0, List.of(List.of(-2, -1, 1, 2), List.of(-2, 0, 0, 2), List.of(-1, 0, 0, 1))),
                Arguments.of(new int[]{2, 2, 2, 2, 2}, 8, List.of(List.of(2, 2, 2, 2))),
                Arguments.of(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296, List.of()),
                Arguments.of(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000, List.of(List.of(0, 0, 0, 1000000000)))
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void fourSum(int[] nums, int target, List<List<Integer>> expected) {
        List<List<Integer>> actual = solution.fourSum(nums, target);

        assertEquals(expected, actual);
    }
}
