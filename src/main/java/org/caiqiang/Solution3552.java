package org.caiqiang;


import java.util.*;

public class Solution3552 {
    public static void main(String[] args) {
        Solution3552 main3 = new Solution3552();
        System.out.println(main3.minMoves(new String[]{"A..", ".A.", "..."}));
//        System.out.println(main3.minMoves(new String[]{".A","CA"}));
//        System.out.println(main3.minMoves(new String[]{".#...", ".#.#.", ".#.#.", "...#."}));
//        System.out.println(main3.minMoves(new String[]{"..C#A","C.B#A","#.A#.","##AC#","..BC.","CA..."}));
//        System.out.println(main3.minMoves(new String[]{"BA.#","FE.F","H..H",".C.."}));
//        System.out.println(main3.minMoves(new String[]{"..BC.C.", "...F..G", "#.F..FA", "D.ABEAB", "E....BE", "ADDF...", "E#..BA.", "#FD#.#A"}));
    }

    private static final int[][] DIRS = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int minMoves(String[] matrix) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[][] ma = new int[matrix.length][matrix[0].length()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length(); j++) {
                char c = matrix[i].charAt(j);
                ma[i][j] = Integer.MAX_VALUE;
                if (c != '.' && c != '#') {
                    int finalI = i;
                    int finalJ = j;
                    map.compute((int) c, (key, old) -> {
                        if (old == null) {
                            List<int[]> list = new ArrayList<>();
                            list.add(new int[]{finalI, finalJ});
                            return list;
                        } else {
                            old.add(new int[]{finalI, finalJ});
                            return old;
                        }
                    });
                }
            }
        }

        ma[0][0] = 0;
        if (matrix[0].charAt(0) == '#' || matrix[matrix.length - 1].charAt(matrix[0].length() - 1) == '#') {
            return -1;
        }
        return bfs(ma, map, matrix);
    }

    private int bfs(int[][] ma, Map<Integer, List<int[]>> map, String[] matrix) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.addLast(new int[]{0, 0});
        while (!deque.isEmpty()) {

            int[] curr = deque.pollFirst();
            int x = curr[0];
            int y = curr[1];

            if (x == matrix.length - 1 && y == matrix[0].length() - 1) {
                //结束
                return ma[x][y];
            }
            char c = matrix[x].charAt(y);

            // 选择走传送，或者选择直接走
            if (c != '.') {
                // 传送
                List<int[]> ints = map.get((int) c);
                if (ints != null) {
                    ints.forEach((arr) -> {
                        if (x != arr[0] || y != arr[1]) {
                            deque.addFirst(arr);// 必须放在最前
                            ma[arr[0]][arr[1]] = Math.min(ma[x][y], ma[arr[0]][arr[1]]);
                        }
                    });
                    map.remove((int) c);
                }
            }
            // 普通走
            for (int[] dir : DIRS) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx >= 0 && nx <= matrix.length - 1 && ny >= 0 && ny <= matrix[0].length() - 1 && c != '#' && ma[x][y] + 1 < ma[nx][ny]) {
                    ma[nx][ny] = ma[x][y] + 1;
                    deque.addLast(new int[]{nx, ny});
                }

            }
        }
        return -1;
    }
}

