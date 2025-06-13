package org.caiqiang;

/**
 * @program: leetcode
 * @description: 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @author: caiqiang
 * @create: 2023-07-21 18:37
 **/
public class Solution42 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int[] heght = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int[] heght1 = new int[]{4,2,0,3,2,5};
        int[] heght2 = new int[]{4,2,3};
//        System.out.println(solution42.trap(heght));
//        System.out.println(solution42.trap(heght1));
        System.out.println(solution42.trap(heght2));
    }

    public int trap(int[] height) {
        int startIndex = 0;
        int result = 0;
        boolean flag = false;
        while (startIndex < height.length - 1) {
            int startValue = height[startIndex];
            int endIndex = startIndex + 1;

            while (endIndex < height.length) {
                int endValue = height[endIndex];
                if (endValue < startValue) {
                    endIndex++;
                    flag = true;
                } else {
                    int middle = (endIndex - startIndex - 1) * Math.min(startValue, endValue);
                    int f = 0;
                    for (int i = startIndex + 1; i < endIndex; i++) {
                        f = f + height[i];
                    }
                    result = result + (middle - f);
                    startIndex = endIndex;
                    flag = false;
                    break;
                }
            }
            if (flag){
                startIndex++;
            }
        }
        return result;
    }

}
