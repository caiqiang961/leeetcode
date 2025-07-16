package org.caiqiang;

public class Solution45_3_again {
    public static void main(String[] args) {
        Solution45_3_again solution45_3_again = new Solution45_3_again();
        System.out.println(solution45_3_again.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution45_3_again.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(solution45_3_again.jump(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution45_3_again.jump(new int[]{1, 1, 1, 1}));
        System.out.println(solution45_3_again.jump(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}));

    }

    int result = 0;

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
//        jumpTest(nums, nums.length - 1);
//        return result;
        return jumpTest2(nums);
    }

    // 递归
    private void jumpTest(int[] nums, int index) {
        if (index <= 0) {
            return;
        }
        int newIndex = -1;
        for (int i = index - 1; i >= 0; i--) {
            int curr = nums[i];
            if (curr + i >= index) {
                newIndex = i;
            }
        }
        if (newIndex == -1) {
            return;
        }
        result++;
        jumpTest(nums, newIndex);
    }

    // 循环
    private int jumpTest2(int[] nums) {
        int result = 0;
        int endIndex = nums.length - 1;
        while (endIndex > 0) {
            int index = -1;
            for (int i = endIndex - 1; i >= 0; i--) {
                int curr = nums[i];
                if (curr + i >= endIndex) {
                    index = i;
                }
            }
            if (index == -1) {
                return -1;
            }
            result++;
            endIndex = index;
        }
        return result;
    }
}
