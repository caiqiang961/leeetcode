package org.caiqiang;

import java.util.*;

public class Solution1971_2 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            int finalI = i;
            map.compute(edges[i][0], (key, oldValue) -> {
                List<Integer> list = oldValue == null ? new ArrayList<>() : oldValue;
                list.add(edges[finalI][1]);
                return list;
            });
            map.compute(edges[i][1], (key, oldValue) -> {
                List<Integer> list = oldValue == null ? new ArrayList<>() : oldValue;
                list.add(edges[finalI][0]);
                return list;
            });
        }
        return bfs(map,source,destination);
    }

    private boolean bfs(Map<Integer, List<Integer>> map, int source, int destination) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(source);
        while (!deque.isEmpty()) {
            Integer curr = deque.pollFirst();
            if (curr == destination) {
                return true;
            }
            List<Integer> list = map.remove(curr);
            if (list != null) {
                list.forEach(deque::addLast);
            }
        }
        return false;
    }
}
