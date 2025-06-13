package org.caiqiang;

import java.util.Arrays;

//45. 跳跃游戏 II
//中等
//相关标签
//相关企业
//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//
//每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
//
//0 <= j <= nums[i]
//i + j < n
//返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
//示例 1:
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//示例 2:
//输入: nums = [2,3,0,1,4]
//输出: 2
//
//提示:
//1 <= nums.length <= 104
//0 <= nums[i] <= 1000
//题目保证可以到达 nums[n-1]
public class Solution45 {

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        System.out.println(solution45.jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution45.jump(new int[]{2, 3, 0, 1, 4}));
        System.out.println(solution45.jump(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution45.jump(new int[]{1, 1, 1, 1}));
        System.out.println(solution45.jump(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}));
        System.out.println("-----");
        System.out.println(solution45.jump1(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution45.jump1(new int[]{2, 3, 0, 1, 4}));
        System.out.println(solution45.jump1(new int[]{1, 1, 1, 1, 1}));
        System.out.println(solution45.jump1(new int[]{1, 1, 1, 1}));
        System.out.println(solution45.jump1(new int[]{5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8, 4, 4, 2, 0, 3, 8, 5}));


    }

    //O(n) 每次在上次能跳到的范围（end）内选择一个能跳的最远的位置（也就是能跳到max_far位置的点）作为下次的起跳点 ！
    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    //我们的目标是到达数组的最后一个位置，因此我们可以考虑最后一步跳跃前所在的位置，该位置通过跳跃能够到达最后一个位置。
    //
    //如果有多个位置通过跳跃都能够到达最后一个位置，那么我们应该如何进行选择呢？直观上来看，我们可以「贪心」地选择距离最后一个位置最远的那个位置，也就是对应下标最小的那个位置。因此，我们可以从左到右遍历数组，选择第一个满足要求的位置。
    //
    //找到最后一步跳跃前所在的位置之后，我们继续贪心地寻找倒数第二步跳跃前所在的位置，以此类推，直到找到数组的开始位置。
    //O(n^2)，其中 nnn 是数组长度。有两层嵌套循环，在最坏的情况下，例如数组中的所有元素都是 111，position 需要遍历数组中的每个位置，对于 position 的每个值都有一次循环。
    //
    //空间复杂度：O(1)

    public int jump1(int[] nums) {
        //俩种写法：
        //递归
        return count1_1(nums, nums.length - 1, 0);
        //循环
//        return count1_2(nums);
    }

    //count1递归写法
    private int count1_1(int[] nums, int endIndex, int minCount) {
        if (endIndex == 0) {
            return minCount;
        }
        minCount++;
        for (int i = 0; i < endIndex; i++) {
            if (nums[i] + i >= endIndex) {
                return count1_1(nums, i, minCount);
            }
        }
        return minCount;
    }

    //count1循环写法
    private int count1_2(int[] nums) {
        int endIndex = nums.length - 1;
        int result = 0;
        while (endIndex > 0) {
            for (int i = 0; i < endIndex; i++) {
                if (nums[i] + i >= endIndex) {
                    endIndex = i;
                    result++;
                    break;
                }
            }

        }
        return result;
    }

    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -2);
        return count(nums, 0, arr);
    }

    //直接暴力遍历,时复太高O(n^2) 解决：用一个arr数组存储每次的最小值，以免重复计算
    private int count(int[] nums, int currentIndex, int[] arr) {
        if (arr[currentIndex] != -2){
            return arr[currentIndex];
        }
        int j = nums[currentIndex];
        int newIndex = j + currentIndex;
        int totalCount = 1;
        if (newIndex >= nums.length - 1) {
            arr[currentIndex] = 1;
            return 1;
        } else {
            //从0开始在原地，没有意义
            int minCount = -1;
            for (int k = currentIndex + 1; k <= newIndex; k++) {
                int resultCount = count(nums, k, arr);
                if (nums[currentIndex] == 0 || resultCount == -1) {//俩个条件其实一样的
                    continue;
                }
                if (minCount == -1 || minCount > resultCount + totalCount) {
                    minCount = resultCount + totalCount;
                }
            }
            arr[currentIndex] = minCount;
            return minCount;
        }
    }
}
