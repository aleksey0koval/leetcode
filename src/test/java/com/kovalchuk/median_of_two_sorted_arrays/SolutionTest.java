package com.kovalchuk.median_of_two_sorted_arrays;

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
                Arguments.of(new int[]{1, 3}, new int[]{2}, 2),
                Arguments.of(new int[]{1, 2}, new int[]{3, 4}, 2.5)
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    void findMedianSortedArrays(int[] nums1, int[] nums2, double expectedMedian) {
        double actualMedian = solution.findMedianSortedArrays(nums1, nums2);

        assertEquals(expectedMedian, actualMedian);
    }
}
