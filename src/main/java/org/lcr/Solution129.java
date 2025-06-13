package org.lcr;

public class Solution129 {
    public boolean wordPuzzle(char[][] grid, String target) {
        if (grid.length*grid[0].length < target.length()){
            return false;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (DFS(0, i, j, grid, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean DFS(int index, int x, int y, char[][] grid, String target) {
        if (index >= target.length()) {
            return true;
        }
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;
        }
        if (grid[x][y] == 1) {
            return false;
        }
        if (grid[x][y] != target.charAt(index)) {
            return false;
        }
        char temp = grid[x][y];
        grid[x][y] = 1;
        boolean v1 = DFS(index + 1, x + 1, y, grid, target);
        if (v1){
            return true;
        }
        boolean v2 = DFS(index + 1, x - 1, y, grid, target);
        if (v2){
            return true;
        }
        boolean v3 = DFS(index + 1, x, y + 1, grid, target);
        if (v3){
            return true;
        }
        boolean v4 = DFS(index + 1, x, y - 1, grid, target);
        if (v4){
            return true;
        }
        grid[x][y] = temp;
        return false;
    }
}
