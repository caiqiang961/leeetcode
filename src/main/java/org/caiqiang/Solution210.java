package org.caiqiang;

import java.util.*;

// 可以把类似的问题转换为图的概念
// 图又分为有向有环图、有向无环图、
//无向有环图、无向无环图、
//这里，课程学习明显是一个有前后之分的图，所以选用有向图，则有向有环图表示无法修完课程，有向有环图则表示可以修完
//即 先修课程 -> 后修课程
public class Solution210 {
    public static void main(String[] args) {
        Solution210 solution210 = new Solution210();
        System.out.println(solution210.canFinish(2, new int[][]{{1, 0}, {2, 0}, {2, 1}, {3, 2}, {4, 3}, {4, -1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 图的入度
        Map<Integer, Integer> map = new HashMap<>();
        // 图的指向
        Map<Integer, List<Integer>> mapEndpoint = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            map.putIfAbsent(prerequisite[1], 0);
            map.merge(prerequisite[0], 1, Integer::sum);
            List<Integer> list = new ArrayList<>();
            list.add(prerequisite[0]);
            mapEndpoint.merge(prerequisite[1], list, (ov, nv) -> {
                ov.add(prerequisite[0]);
                return ov;
            });
        }
        System.out.println(map);

        System.out.println(mapEndpoint);

        return startBfs(map, mapEndpoint);

    }

    private boolean startBfs(Map<Integer, Integer> map, Map<Integer, List<Integer>> mapEndpoint) {
        //入度、指向已经拿到，开始进行BFS、DFS
        Deque<Integer> deque = new ArrayDeque<>();
        while (true) {
            if (map.size() == 0) {
                return true;
            }
            map.forEach((k, v) -> {
                if (v == 0) {
                    deque.addLast(k);
                }
            });
            if (deque.isEmpty()) {
                return false;
            }
            deque.forEach(map::remove);
            while (!deque.isEmpty()) {
                Integer integer = deque.removeFirst();
                List<Integer> list = mapEndpoint.get(integer);
                if (list != null && list.size() != 0) {
                    list.forEach(l -> map.put(l, map.get(l) - 1));
                }
            }
        }
    }

}
