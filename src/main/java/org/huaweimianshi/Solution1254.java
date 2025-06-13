package org.huaweimianshi;

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
 * 输入：grid = [
 * [1,1,1,1,1,1,1,0],
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
public class Solution1254 {
    public static void main(String[] args) {
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        int[][] grid1 = {{0,0,1,0,0},{0,1,0,1,0},{0,1,1,1,0}};
        int[][] grid2 = {{1,1,1,1,1,1,1},{1,0,0,0,0,0,1},{1,0,1,1,1,0,1},{1,0,1,0,1,0,1},{1,0,1,1,1,0,1},{1,0,0,0,0,0,1},{1,1,1,1,1,1,1}};

        Solution1254 solution1254 = new Solution1254();
        System.out.println(solution1254.closedIsland(grid));
        System.out.println(solution1254.closedIsland(grid1));
        System.out.println(solution1254.closedIsland(grid2));
    }

    //深度优先搜索  递归
    public int closedIsland(int[][] grid) {
        int num = 0;
        //不从边界开始
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[i].length - 1; j++) {
                int curr = grid[i][j];
                //当前是水 则直接进行下一次
                if (curr == 0) {
                    //向四个方向进行查找
                    boolean b = siFangFor(grid, i, j);
                    if (b) {
                        num++;
                    }
                }
            }
        }
        return num;
    }
    private boolean siFangFor(int[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j< 0 || j >= grid[0].length) {
            return false;
        }
        int curr = grid[i][j];
        grid[i][j] = 2;

        if (curr == 0){
            //currUp
            boolean currUp = siFangFor(grid, i - 1, j);//深度   一条路走到黑，再走下一条
            //currDown
            boolean currDown = siFangFor(grid, i + 1, j);
            //currLeft
            boolean currLeft = siFangFor(grid, i, j - 1);
            //currRight
            boolean currRight = siFangFor(grid, i, j + 1);
           return currUp && currDown && currLeft && currRight;
        }else {//1 和 2 直接返回true   1表示遇到了水  则返回true就ok    2表示有人其他方向已经处理过这块index，那么那个处理的一定有true或者false，我直接返回true
            return true;
        }
    }
}
