package org.caiqiang;

import java.util.*;

// 可以把类似的问题转换为图的概念
// 图又分为有向有环图、有向无环图、
//无向有环图、无向无环图、
//这里，课程学习明显是一个有前后之分的图，所以选用有向图，则有向有环图表示无法修完课程，有向无环图则表示可以修完
//即 先修课程 -> 后修课程
public class Solution207 {
    public static void main(String[] args) {
        Solution207 solution207 = new Solution207();
//        System.out.println(solution207.canFinish(2, new int[][]{{1, 0}, {2, 0}, {2, 1}, {3, 2}, {4, 3}, {4, -1}}));
//        System.out.println(solution207.startDfs(2, new int[][]{{1, 0}, {2, 0}, {2, 1}, {3, 2}, {4, 3}, {4, -1}}));
//        System.out.println(solution207.startDfs(5, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        System.out.println(solution207.startDfs(3, new int[][]{{0,1},{1,0},{1,2}}));
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

    //BFS使用入度，找的是先修课程
    //DFS使用出度，找的是最高阶课程，依次向下
    private boolean startDfs(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites.length == 0){
            return true;
        }
        // 图的出度
        Map<Integer, Integer> mapOut = new HashMap<>();
        Map<Integer, Integer> mapInput = new HashMap<>();
        // 图的低到高指向
        Map<Integer, List<Integer>> mapLowEndpoint = new HashMap<>();
        // 图的高到低指向
        Map<Integer, List<Integer>> mapHighEndpoint = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            mapInput.putIfAbsent(prerequisite[1], 0);
            mapInput.merge(prerequisite[0], 1, Integer::sum);

            mapOut.merge(prerequisite[1], 1, (ov, nv) -> ov + 1);
            mapOut.putIfAbsent(prerequisite[0], 0);

            List<Integer> list = new ArrayList<>();
            list.add(prerequisite[0]);//4，-1
            mapLowEndpoint.merge(prerequisite[1], list, (ov, nv) -> {
                ov.add(prerequisite[0]);
                return ov;
            });

            List<Integer> list1 = new ArrayList<>();
            list1.add(prerequisite[1]);
            mapHighEndpoint.merge(prerequisite[0], list1, (ov, nv) -> {
                ov.add(prerequisite[1]);
                return ov;
            });
        }
        for (int i = 0; i < numCourses; i++) {
            mapInput.putIfAbsent(i,0);
            mapOut.putIfAbsent(i,0);
            mapLowEndpoint.putIfAbsent(i,new ArrayList<>());
            mapHighEndpoint.putIfAbsent(i,new ArrayList<>());
        }
        // 使用入度可以找到头部
        System.out.println("入度：" + mapInput);
        // 使用出度可以找到尾部
        System.out.println("出度：" + mapOut);

        System.out.println("低指向高：" + mapLowEndpoint);
        System.out.println("高指向低：" + mapHighEndpoint);
        List<Integer> flag = new ArrayList<>();
        mapInput.forEach((k, v) -> {
            if (v == 0) {
                flag.add(k);
            }
        });

        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        dfs(flag, mapOut, mapLowEndpoint,stack,set);
        System.out.println(stack);
        return stack.size() == numCourses;
    }

    private void dfs(List<Integer> currentList, Map<Integer, Integer> mapOut, Map<Integer, List<Integer>> mapLowEndpoint,Stack<Integer> stack,Set<Integer> set) {
        if (currentList == null || currentList.size() == 0) {
            return;
        }
        for (Integer key : currentList) {
            if (set.contains(key)){
//                return;
                continue;
            }else {
                set.add(key);
            }
            List<Integer> list = mapLowEndpoint.get(key);
            if (list == null || list.size() == 0) {
                stack.push(key);
                continue;
            }
            dfs(list, mapOut, mapLowEndpoint,stack,set);
            int outDu = mapOut.get(key) - list.size();
            mapOut.put(key, outDu);
            if (outDu == 0){
                stack.push(key);
            }
        }
    }
}
