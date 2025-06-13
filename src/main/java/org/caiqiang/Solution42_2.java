package org.caiqiang;

import java.util.PriorityQueue;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
public class Solution42_2 {
    
    // 准备俩个数组，lArr lArr[i]表示在下标为i位置向左，最大的墙高
    //             rArr rArr[i]表示在下标为i位置向右，最大的墙高
    // result = 每一个位置i的lArr[i]和rArr[i]的最小值 - 当前下标的墙高
    public int trap(int[] height) {
        int[] lArr = new int[height.length];
        int[] rArr = new int[height.length];
        int result = 0;
        lArr[0] = height[0];
        rArr[height.length - 1] = height[height.length - 1];

        for (int i = 1; i < height.length; i++) {
            lArr[i] = Math.max(lArr[i - 1], height[i]);
        }
        for (int i = height.length - 1 - 1; i >= 0; i--) {
            rArr[i] = Math.max(rArr[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            result += Math.min(lArr[i], rArr[i]) - height[i];
        }

        return result;
    }
}
