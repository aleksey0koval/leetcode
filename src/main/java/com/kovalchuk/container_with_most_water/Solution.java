package com.kovalchuk.container_with_most_water;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];
            int tempArea = (right - left) * min(leftHeight, rightHeight);
            maxArea = max(maxArea, tempArea);
            if (leftHeight > rightHeight) {
                right--;
            } else if (leftHeight < rightHeight) {
                left++;
            } else {
                left++;
                right--;
            }
        }
        return maxArea;
    }
}
