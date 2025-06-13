package org.caiqiang;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution841_2 {
    int num = 0;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] dis = new boolean[rooms.size()];
//        dfs(dis, rooms, 0);
        bfs(dis, rooms);
        return num == rooms.size();
    }

    private void dfs(boolean[] dis, List<List<Integer>> rooms, int index) {
        if (dis[index]) {
            return;
        }
        dis[index] = true;
        num++;
        for (int i = 0; i < rooms.get(index).size(); i++) {
            dfs(dis, rooms, rooms.get(index).get(i));
        }
    }

    private void bfs(boolean[] dis, List<List<Integer>> rooms){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        while (!deque.isEmpty()){
            Integer curr = deque.pollFirst();
            if (!dis[curr]){
                num++;
                dis[curr] = true;
                rooms.get(curr).forEach(deque::addLast);
            }
        }
    }
}
