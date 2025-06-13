package org.caiqiang;

import java.util.*;

public class Solution1971 {
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
        return dfs(map,source,destination);
    }

    // 根节点引用，可达性分析
    private boolean dfs(Map<Integer, List<Integer>> map, int source, int destination) {
        if (source == destination){
            return true;
        }
        if (!map.containsKey(destination)){
            return false;
        }
        if (!map.containsKey(source)){
            return false;
        }
        // 拿出来就删除，避免无限循环
        List<Integer> list = map.remove(source);
        for (Integer integer : list) {
            if (dfs(map, integer, destination)) {
                return true;
            }
        }
        return false;
    }


}
