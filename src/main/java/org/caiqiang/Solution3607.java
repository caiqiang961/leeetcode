package org.caiqiang;

import java.util.*;

public class Solution3607 {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> noLineList = new HashSet<>();
        for (int[] connection : connections) {
            int code1 = connection[0];
            int code2 = connection[1];
            Set<Integer> set1 = map.get(code1);
            Set<Integer> set2 = map.get(code2);
            Set<Integer> set;
            if (set1 == null && set2 == null) {
                set = new HashSet<>();
            } else {
                if (set1 != null) {
                    set = set1;
                } else {
                    set = set2;
                }
            }
            set.add(code1);
            set.add(code2);
            map.put(code1, set);
            map.put(code2, set);
        }
        for (int[] query : queries) {
            int status = query[0];
            if (status == 2) {
                noLineList.add(query[1]);
            }
        }
        for (int[] query : queries) {
            if (query[0] == 1 && !noLineList.contains(query[1])) {
                // 在线
                list.add(query[1]);
            } else {
                // 离线
                //找到最小在线
                Set<Integer> set = map.get(query[1]);
                if (set == null || set.size() == 0) {
                    list.add(-1);
                    continue;
                }
                set.forEach(s -> {
                    if (!noLineList.contains(s)) {
                        list.add(s);
                    }
                });
            }
        }
        int[] re = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            re[i] = list.get(i);
        }
        return re;
    }
}
