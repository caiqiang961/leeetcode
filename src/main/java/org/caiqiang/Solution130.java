package org.caiqiang;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution130 {
    public static void main(String[] args) {
        Solution130 solution130 = new Solution130();
//        solution130.solve(new char[][]{
//                {'O', 'O', 'O', 'O', 'X', 'X'},
//                {'O', 'O', 'O', 'O', 'O', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'O'},
//                {'O', 'X', 'O', 'O', 'X', 'O'},
//                {'O', 'X', 'O', 'X', 'O', 'O'},
//                {'O', 'X', 'O', 'O', 'O', 'O'}
//        });
//        char[][] chars = {
//                {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
//        };
        char[][] chars = {
                {'O','O'},{'O','O'}
        };
        solution130.solve(chars);
        
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j] + "  ");
            }
            System.out.println();
        }
    }


    //bfs写法
    public void solve_bfs(char[][] board){
        Deque<int[]> deque  = new ArrayDeque<>();
        for (int i = 0; i < board.length; i++) {
            deque.addLast(new int[]{i, 0});
            deque.addLast(new int[]{i, board[i].length - 1});
        }
        for (int i = 0; i < board[0].length; i++) {
            deque.addLast(new int[]{0, i});
            deque.addLast(new int[]{board.length - 1, i});
        }
        while (!deque.isEmpty()){
            int[] ints = deque.removeFirst();
            if (ints[0] < 0 || ints[1] < 0 || ints[0] >= board.length || ints[1] >= board[0].length){
                continue;
            }
            if (board[ints[0]][ints[1]] == 'O'){
                board[ints[0]][ints[1]] = 'A';
                deque.addLast(new int[]{ints[0]+1,ints[1]});
                deque.addLast(new int[]{ints[0]-1,ints[1]});
                deque.addLast(new int[]{ints[0],ints[1] + 1});
                deque.addLast(new int[]{ints[0],ints[1] - 1});
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                    continue;
                }
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    //dfs写法
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            dfs(board, i, 0);
            dfs(board, i, board[i].length - 1);
        }
        for (int i = 0; i < board[0].length; i++) {
            dfs(board, 0, i);
            dfs(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'A'){
                    board[i][j] = 'O';
                    continue;
                }
                if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'A' || board[i][j] == 'X'){
            return;
        }
        if (board[i][j] == 'O'){
            board[i][j] = 'A';
        }
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
       
    }



}
