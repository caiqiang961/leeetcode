package org.huaweimianshi;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 二维矩阵 grid 由 0 （土地）和 1 （水）组成。岛是由最大的4个方向连通的 0 组成的群，
 * 封闭岛是一个 完全 由1包围（左、上、右、下）的岛。
 * <p>
 * 请返回 封闭岛屿 的数目。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1,0],
 * [1,0,0,0,0,1,1,0],
 * [1,0,1,0,1,1,1,0],
 * [1,0,0,0,0,1,0,1],
 * [1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1],
 *              [1,0,0,0,0,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,1,0,1,0,1],
 *              [1,0,1,1,1,0,1],
 *              [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/number-of-closed-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution1254X1 {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 1, 1, 0}, {1, 0, 0, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0}};
        int[][] grid1 = {{0, 0, 1, 0, 0}, {0, 1, 0, 1, 0}, {0, 1, 1, 1, 0}};
        int[][] grid2 = {{1, 1, 1, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 1, 0, 1, 0, 1}, {1, 0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 1}};
        int[][] grid3 = {{0, 0, 1, 1, 0, 1, 0, 0, 1, 0}, {1, 1, 0, 1, 1, 0, 1, 1, 1, 0}, {1, 0, 1, 1, 1, 0, 0, 1, 1, 0}, {0, 1, 1, 0, 0, 0, 0, 1, 0, 1}, {0, 0, 0, 0, 0, 0, 1, 1, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 1, 1, 1}, {1, 0, 1, 0, 1, 1, 0, 0, 0, 1}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 1, 0, 1, 0, 1}, {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}};

        Solution1254X1 solution1254 = new Solution1254X1();
//        System.out.println(solution1254.closedIsland(grid));
//        System.out.println(solution1254.closedIsland(grid1));
//        System.out.println(solution1254.closedIsland(grid2));
        System.out.println(solution1254.closedIsland(grid3));
    }
//
// {0,0,1,1,0,1,0,0,1,0},
// {1,1,x,1,1,0,1,1,1,0},
// {1,x,1,1,1,0,0,1,1,0},
// {0,1,1,0,0,0,0,1,x,1},
// {0,0,0,0,0,0,1,1,1,0},
// {0,1,0,1,0,1,0,1,1,1},
// {1,x,1,x,1,1,0,0,0,1},
// {1,1,1,1,1,1,0,0,0,0},
// {1,1,1,0,0,1,0,1,0,1},
// {1,1,1,0,1,1,0,1,1,0}


    //广度优先搜索  递归
    public int closedIsland(int[][] grid) {
        int num = 0;
        //不从边界开始
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                int curr = grid[i][j];
                //当前是水 则直接进行下一次
                if (curr == 0) {
                    Queue<int[]> queue = new ArrayDeque<>();
                    queue.offer(new int[]{i, j});
                    boolean b = true;
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        if (poll[0] < 0 || poll[1] < 0 || poll[0] >= grid.length || poll[1] >= grid[0].length) {
                            b = false;
                            continue;
                           // break;//不能使用退出    即使不是一个岛，也必须便利，把他能遍历岛的所有地方走完，之后就不用再在大的双层for循环中遍历这个点了
                        }
                        if (grid[poll[0]][poll[1]] == 0) {
                            grid[poll[0]][poll[1]] = 2;
                            siFangFor(poll[0], poll[1], queue);
                        }
                    }
                    if (b) {
                        num++;
                    }
                }
            }
        }
        return num;
    }

    private void siFangFor(int i, int j, Queue<int[]> queue) {
        queue.offer(new int[]{i - 1, j});
        queue.offer(new int[]{i + 1, j});
        queue.offer(new int[]{i, j - 1});
        queue.offer(new int[]{i, j + 1});
    }

}
