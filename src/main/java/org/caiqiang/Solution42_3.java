package org.caiqiang;

public class Solution42_3 {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int result = 0;
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }
        for (int i = height.length - 1 - 1; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            result = result + (Math.min(right[i], left[i]) - height[i]);
        }
        return result;
    }
}
