package com.kovalchuk.median_of_two_sorted_arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2))
                .sorted()
                .toArray();

        return result.length % 2 == 0
                ? (result[(result.length / 2)] + result[result.length / 2 - 1]) / 2.0
                : result[(result.length - 1) / 2];
    }
}
