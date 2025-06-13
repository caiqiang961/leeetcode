package org.caiqiang;

import java.util.Arrays;

public class Solution75 {
    public static void main(String[] args) {
        Solution75 solution75 = new Solution75();
        int[] arr = new int[]{1, 2, 2, 3, 1, 6, 4, 5, 7, 2, 5, 8, 2};
//        solution75.sortColors(arr);
//        solution75.sortColors2(arr);
        solution75.sortColors3(arr);
        System.out.println(Arrays.toString(arr));

    }

    // 冒泡 相邻元素比较，逐步将最大元素“冒泡”到序列最后。时间复杂度O(n^2)。
    public void sortColors(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    // 选择 从序列中选择最小的元素，放到序列的起始位置，再从剩余元素中选择最小的元素放到已排序序列的末尾。时间复杂度O(n^2)。
    public void sortColors2(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
        }
    }

    // 插入 将序列分为已排序和未排序两部分，从未排序的部分选择元素插入到已排序的部分中，直到所有元素都被插入到已排序的部分。时间复杂度O(n^2)。
    public void sortColors3(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                if (current < nums[j]) {
                    int temp = nums[j];
                    nums[j] = current;
                    nums[j + 1] = temp;
                }
            }

        }
    }
}
