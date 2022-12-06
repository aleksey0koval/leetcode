package com.kovalchuk.remove_duplicates_from_sorted_array;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int temp = nums[0];
        int size = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > temp) {
                temp = nums[i];
                nums[size] = temp;
                size++;
            }
        }
        return size;
    }
}
