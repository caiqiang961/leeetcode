package org.caiqiang;

import java.util.Arrays;
import java.util.Stack;

//84. 柱状图中最大的矩形
//困难
//相关标签
//相关企业
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
//求在该柱状图中，能够勾勒出来的矩形的最大面积。
public class Solution84 {
    public static void main(String[] args) {
        Solution84 solution84 = new Solution84();
        System.out.println(solution84.largestRectangleArea1(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(solution84.largestRectangleArea1(new int[]{2, 4}));
        System.out.println(solution84.largestRectangleArea1(new int[]{6,7,5,2,4,5,9,3}));
    }

    // 暴力遍历,超时
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            int currentHigh = heights[i];
            int left = i;
            while (left >= 0){
                if (heights[left] < currentHigh){
                    break;
                }
                left--;
            }

            int right = i;
            while (right < length){
                if (heights[right] < currentHigh){
                    break;
                }
                right++;
            }
            // 多减或加一次，还原
            left++;
            right--;
            int wide = right - left + 1;
           res = Math.max(res,wide *currentHigh);
        }
        return res;
    }

    // 单调栈,搞一个数组，存放着每一个下标对应的高度的坐边界和右边界
    public int largestRectangleArea1(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        // 存放下标i这个柱子的高度能支持的左边界下标， -1 标识左边一直可以到头
        int[] leftArr = new int[heights.length];
        // 存放下标i这个柱子的高度能支持的右边界下标  -1 标识右边一直可以到头
        int[] rightArr = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            int current = heights[i];
            while (true){
                Integer peek = stack.peek();
                if (peek == -1 || current > heights[peek]) {
                    leftArr[i] = peek;
                    stack.push(i);
                    break;
                }else {
                    stack.pop();
                }
            }
        }

        stack.clear();
        stack.push(-1);

        for (int i = heights.length - 1; i >= 0 ; i--) {
            int current = heights[i];
            while (true){
                Integer peek = stack.peek();
                if (peek == -1 || current > heights[peek]){
                    stack.push(i);
                    rightArr[i] = peek;
                    break;
                }else {
                    stack.pop();
                }
            }
        }

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (rightArr[i] == -1){
                rightArr[i] = heights.length;
            }
            res = Math.max(res,(rightArr[i] - leftArr[i] - 1) * heights[i] );
        }

        return res;
    }
}
