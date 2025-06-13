package org.caiqiang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution797 {
    public static void main(String[] args) {
        Solution797 solution797 = new Solution797();
        System.out.println(solution797.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(result, deque, graph, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, Deque<Integer> deque, int[][] graph, int source) {
        deque.addLast(source);
        if (source == graph.length - 1) {
            result.add(new ArrayList<>(deque));
            deque.removeLast();
            return;
        }
        for (int i = 0; i < graph[source].length; i++) {
            dfs(result, deque, graph, graph[source][i]);
        }
        deque.removeLast();
    }

    private void bfs(List<List<Integer>> result, Deque<Integer> deque, int[][] graph) {
        deque.addLast(0);
        while (!deque.isEmpty()) {
            Integer curr = deque.getFirst();
            if (curr == graph.length - 1) {
                // 没法使用bfs，bfs不能清楚链路状态，无法获取之前的链路
                result.add(new ArrayList<>());
                continue;
            }
            for (int i = 0; i < graph[curr].length; i++) {
                deque.addLast(graph[curr][i]);
            }
        }
    }
}
