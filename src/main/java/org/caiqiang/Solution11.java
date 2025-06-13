package org.caiqiang;

import java.awt.event.ItemEvent;

/**
 * @program: leetcode
 * @description:给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 *
 * 输入：height = [1,1]
 * 输出：1
 *  
 *
 * 提示：
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: caiqiang
 * @create: 2022-02-22 18:27
 **/
public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.maxArea(new int[]{4, 3, 2, 1, 4}));
    }
    public int maxArea(int[] height) {
        if (height.length < 2){
            return 0;
        }
        if (height.length == 2){
            return Math.min(height[0],height[1]);
        }
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; j < height.length; j++) {
                int temp = Math.min(height[i],height[j]) * (j-i);
                if (result < temp){
                    result = temp;
                }
            }
        }
        return result;

    }
    public int maxArea1(int[] height) {
        if (height.length < 2){
            return 0;
        }
        if (height.length == 2){
            return Math.min(height[0],height[1]);
        }
        int result = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        while (leftIndex < rightIndex){
            int temp = Math.min(height[leftIndex],height[rightIndex]) * (rightIndex-leftIndex);
            if (result < temp){
                result = temp;
            }
            if (height[leftIndex] > height[rightIndex]){
                rightIndex --;
            }else {
                leftIndex ++ ;
            }
        }

        return result;

    }

}
