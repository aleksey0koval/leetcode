package com.kovalchuk.four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    long temp = (long) nums[i] + (long) nums[j] + (long) nums[k] + (long) nums[l];
                    if (temp > Integer.MAX_VALUE) {
                        k++;
                        continue;
                    }
                    if (temp < Integer.MIN_VALUE) {
                        l--;
                        continue;
                    }
                    if (temp == target) {
                        result.add(List.of(nums[i], nums[j], nums[k], nums[l]));
                        while (k < l && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l - 1]) {
                            l--;
                        }
                        k++;
                        l--;
                    } else if (temp > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return result;
    }
}
