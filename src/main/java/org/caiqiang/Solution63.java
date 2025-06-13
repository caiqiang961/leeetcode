package org.caiqiang;

// 有障碍物的不同路径,1为障碍物
public class Solution63 {
    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
//        System.out.println(solution63.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
        System.out.println(solution63.uniquePathsWithObstacles(new int[][]{{1,0}}));
//        System.out.println(solution63.uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
//        System.out.println(solution63.uniquePathsWithObstacles(new int[][]{{0,0},{0,1}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1){
            return 0;
        }
//        obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = -1;
//        startDFS(obstacleGrid, 0, 0);
//        return dfsCount;



        return startDonTaiGuiHua(obstacleGrid);
    }

    int dfsCount = 0;

    private void startDFS(int[][] obstacleGrid, int x, int y) {
        if (x >= obstacleGrid.length || y >= obstacleGrid[0].length) {
            return;
        }
        if (obstacleGrid[x][y] == -1) {
            dfsCount++;
            return;
        }
        if (obstacleGrid[x][y] == 0) {
            obstacleGrid[x][y] = 2;
            startDFS(obstacleGrid, x, y + 1);
            startDFS(obstacleGrid, x + 1, y);
            obstacleGrid[x][y] = 0;
        }

    }

    private int startDonTaiGuiHua(int[][] obstacleGrid){
        boolean iFlag = false;
        // 初始化第一列，遇到障碍则障碍和其下方的都为0步骤
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1){
                obstacleGrid[i][0] = 0;
                iFlag = true;
            }
            if (!iFlag){
                obstacleGrid[i][0] = 1;
            }else {
                obstacleGrid[i][0] = 0;
            }
        }

        iFlag = false;
        // 初始化第一行，遇到障碍则障碍和其右方的都为0步骤
        for (int i = 1; i < obstacleGrid[0].length; i++) {
           if (obstacleGrid[0][i] == 1){
               obstacleGrid[0][i] = 0;
               iFlag = true;
           }
           if (!iFlag){
               obstacleGrid[0][i] = 1;
           }else {
               obstacleGrid[0][i] = 0;
           }
        }

        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1){
                    obstacleGrid[i][j] = 0;
                    continue;
                }
               obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
