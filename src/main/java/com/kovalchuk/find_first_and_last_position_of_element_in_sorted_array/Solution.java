package com.kovalchuk.find_first_and_last_position_of_element_in_sorted_array;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{helper(nums, target, false), helper(nums, target, true)};
    }

    private static int helper(int[] nums, int target, boolean isLast) {
        int start = 0;
        int end = nums.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isLast) {
                if (nums[mid] <= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid] >= target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (nums[mid] == target) {
                index = mid;
            }
        }
        return index;
    }
}
