package com.kovalchuk.find_first_and_last_position_of_element_in_sorted_array;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = helper(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, helper(nums, target + 1) - 1};
    }

    private static int helper(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
