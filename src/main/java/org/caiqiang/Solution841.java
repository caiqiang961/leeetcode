package org.caiqiang;

import java.util.*;

public class Solution841 {
    public static void main(String[] args) {
        Solution841 solution841 = new Solution841();
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room0 = new ArrayList<>();
        room0.add(2);
        room0.add(3);
        List<Integer> room1 = new ArrayList<>();
        List<Integer> room2 = new ArrayList<>();
        room2.add(2);
        List<Integer> room3 = new ArrayList<>();
        room3.add(1);
        room3.add(3);
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        System.out.println(solution841.canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < rooms.size(); i++) {
            int finalI = i;
            map.compute(i, (key, oldValue) -> {
                Set<Integer> set = oldValue == null ? new HashSet<>() : oldValue;
                set.addAll(rooms.get(finalI));
                return set;
            });
        }
//        return dfs(0, map);
        return bfs( map);
    }

    private boolean dfs(int index, Map<Integer, Set<Integer>> map) {
        if (map.size() == 0) {
            return true;
        }
        Set<Integer> set = map.remove(index);
        if (set == null || set.size() == 0) {
            return map.size() == 0;
        }
        for (Integer integer : set) {
            if (dfs(integer, map)) {
                return true;
            }
        }
        return false;
    }

    private boolean bfs(Map<Integer, Set<Integer>> map) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        while (!deque.isEmpty()) {
            Integer curr = deque.pollFirst();
            Set<Integer> set = map.remove(curr);
            if (set == null || set.size() == 0) {
                 if (map.size() == 0){
                     return true;
                 }
                 continue;
            }
            set.forEach(s->{
                if (!deque.contains(s)){
                    deque.addLast(s);
                }
            });
        }
        return map.size() == 0;
    }
}
