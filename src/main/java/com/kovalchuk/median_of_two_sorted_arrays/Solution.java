package com.kovalchuk.median_of_two_sorted_arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:
Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example 2:
Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

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
