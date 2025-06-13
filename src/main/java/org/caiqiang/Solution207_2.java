package org.caiqiang;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

// 只要有环就不行
public class Solution207_2 {
    public static void main(String[] args) {
        Solution207_2 s = new Solution207_2();
        System.out.println(s.canFinish(3, new int[][]{{1, 0}, {0, 2}}));
        System.out.println(s.canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}}));
        System.out.println(s.canFinish(4, new int[][]{{1, 4}, {2, 4}, {3, 1}, {3, 2}}));
        System.out.println(s.canFinish(4, new int[][]{{1, 0}, {2, 6}, {1, 7}, {6, 4}, {7, 0}, {0, 5}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || numCourses == 1) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            int i = prerequisite[0];
            int i1 = prerequisite[1];
            map.compute(i, (key, oleValue) -> {
                List<Integer> list;
                if (oleValue == null) {
                    list = new ArrayList<>();
                } else {
                    list = oleValue;
                }
                list.add(i1);
                return list;
            });
        }
        Set<Integer> creatingSets = new HashSet<>();
        // 优化增加一个dfs状态存储
        Map<Integer, Boolean> mapRe = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> next : map.entrySet()) {
            if (!startDfs(map, creatingSets, next.getKey(), mapRe)) {
                return false;
            }else {
                mapRe.put(next.getKey(),true);
            }
        }
        return true;
    }

    // {1, (0,2)},
    // {0, (1)  }


    //{1, 4},
    // {2, 4},
    // {3,(1,2)}

    // {1,0 7},
    // {2,6},
    // {6,4},
    // {7,0},
    // {0,5}

    // 根节点引用，spring循环依赖都是dfs
    private boolean startDfs(Map<Integer, List<Integer>> map, Set<Integer> creatingSets, int k, Map<Integer, Boolean> mapRe) {
        if (mapRe.containsKey(k)){
            return true;
        }
        if (creatingSets.contains(k)) {
            return false;
        } else {
            creatingSets.add(k);
        }
        List<Integer> list = map.get(k);
        if (list == null) {
            // 不可能，但写着也可以
            // 从根寻找结束
            creatingSets.remove(k);// 一条可达性分析之后，要逐一退出
            return true;
        }
        for (Integer integer : list) {
            if (!startDfs(map, creatingSets, integer, mapRe)) {
                return false;
            }else {
                mapRe.put(integer,true);
            }
        }
        // 一次根节点引用算法结束x
        creatingSets.remove(k);
        return true;
    }
}
