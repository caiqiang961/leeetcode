package org.caiqiang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//56. 合并区间
//中等
//相关标签
//相关企业
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//
//
//
//示例 1：
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//示例 2：
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//提示：
//
//1 <= intervals.length <= 104
//intervals[i].length == 2
//0 <= starti <= endi <= 104
public class Solution56 {
    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        System.out.println(Arrays.deepToString(solution56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}, {-10, 2}})));
        System.out.println(Arrays.deepToString(solution56.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
        System.out.println(Arrays.deepToString(solution56.merge(new int[][]{{1, 4}, {0, 5}})));
        System.out.println(Arrays.deepToString(solution56.merge(new int[][]{{2, 3}, {4, 5}, {6, 7}, {8, 9}, {1, 10}})));
    }

    public int[][] merge(int[][] intervals) {
        int[][] ints;
        int[][] ints1;
        do {
            ints = me(intervals);
            ints1 = me(ints);
            intervals = ints1;
        } while (ints.length != ints1.length);
        return ints1;
    }

    public int[][] me(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int[] nums = new int[intervals.length * 2];
        for (int i = 0; i < intervals.length; i++) {
            nums[i * 2] = intervals[i][0];
            nums[i * 2 + 1] = intervals[i][1];
        }
        for (int i = 0; i < nums.length; i++) {
            boolean startFlag = i % 2 == 0;
            if (!startFlag) {
                continue;
            }
            boolean flag = false;
            for (int[] ints : result) {
                // nums[i]在不在已有区间中

                //开始值在区间
                if (nums[i] >= ints[0] && nums[i] <= ints[1]) {
                    flag = true;
                    //如果开始值在区间内，看看结束值怎么取
                    ints[1] = Math.max(ints[1], nums[i + 1]);
                    break;
                }
                //结束值在区间
                if (nums[i + 1] >= ints[0] && nums[i + 1] <= ints[1]) {
                    flag = true;
                    //如果开始值在区间内，看看结束值怎么取
                    ints[0] = Math.min(ints[0], nums[i]);
                    break;
                }
                //开始结束都不在区间，但是是把区间包含在哪的情况 比如区间为1，4   开始为0 结束为5
                if (nums[i] < ints[0] && nums[i + 1] > ints[1]) {
                    ints[0] = nums[i];
                    ints[1] = nums[i + 1];
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                result.add(new int[]{nums[i], nums[i + 1]});
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

}
