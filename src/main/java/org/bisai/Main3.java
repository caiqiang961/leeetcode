package org.bisai;

import java.util.*;

public class Main3 {
    int resultCount = -1;

    // dfs是暴力的想法，你现在需要的是最短路径，应该使用图想法，更新节点最短路径
    public static void main(String[] args) {
        Main3 main3 = new Main3();
        System.out.println(main3.minMoves(new String[]{"A..", ".A.", "..."}));
        System.out.println(main3.minMoves(new String[]{".#...", ".#.#.", ".#.#.", "...#."}));
        System.out.println(main3.minMoves(new String[]{"..C#A","C.B#A","#.A#.","##AC#","..BC.","CA..."}));
        System.out.println(main3.minMoves(new String[]{"BA.#","FE.F","H..H",".C.."}));
        System.out.println(main3.minMoves(new String[]{"..BC.C.", "...F..G", "#.F..FA", "D.ABEAB", "E....BE", "ADDF...", "E#..BA.", "#FD#.#A"}));
    }

    public int minMoves(String[] matrix) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> sets = new HashSet<>();
        Map<Integer, List<int[]>> map = new HashMap<>();
        int[][] ma = new int[matrix.length][matrix[0].length()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length(); j++) {
                char c = matrix[i].charAt(j);
                if (c == '.') {
                    ma[i][j] = 0;
                } else if (c == '#') {
                    ma[i][j] = -1;
                } else {
                    ma[i][j] = c;
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
        for (int i = 0; i < ma.length; i++) {
            for (int j = 0; j < ma[i].length; j++) {
                System.out.print(ma[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        if (ma[0][0] == -1 || ma[ma.length - 1][ma[0].length - 1] == -1) {
            return -1;
        }
        dfs(ma, 0, 0, 0, result, sets, map);
        if (result.size() == 0) {
            return -1;
        }
        Collections.sort(result);
        return result.get(0);
    }

    private void dfs(int[][] ma, int x, int y, int step, List<Integer> result, Set<Integer> sets, Map<Integer, List<int[]>> map) {
        if (x < 0 || x >= ma.length || y < 0 || y >= ma[0].length) {
            return;
        }

        if (resultCount != -1 && step >= resultCount) {
            return;
        }
        if (x == ma.length - 1 && y == ma[0].length - 1) {
            result.add(step);
            // 成功
            return;
        }
        if (ma[x][y] == -1 || ma[x][y] == -2) {
            // 失败
            return;
        }
        int curr = ma[x][y];
        List<int[]> ints = map.get(curr);
        ma[x][y] = -2;
        // ==0 或者不满足传送条件
        if (curr == 0 || sets.contains(curr) || (ints != null && ints.size() == 1)) {
            dfs(ma, x + 1, y, step + 1, result, sets, map);
            dfs(ma, x - 1, y, step + 1, result, sets, map);
            dfs(ma, x, y - 1, step + 1, result, sets, map);
            dfs(ma, x, y + 1, step + 1, result, sets, map);
        } else {
            // 可以选择不坐传送
            dfs(ma, x + 1, y, step + 1, result, sets, map);
            dfs(ma, x - 1, y, step + 1, result, sets, map);
            dfs(ma, x, y - 1, step + 1, result, sets, map);
            dfs(ma, x, y + 1, step + 1, result, sets, map);
            // 坐传送
            assert ints != null;
            sets.add(curr);
            for (int i = 0; i < ints.size(); i++) {
                int[] ints1 = ints.get(i);
                if (ints1[0] == x && ints1[1] == y) {
                    continue;
                }
                dfs(ma, ints1[0], ints1[1], step, result, sets, map);
            }
            sets.remove(curr);
        }
        ma[x][y] = curr;
    }

}
