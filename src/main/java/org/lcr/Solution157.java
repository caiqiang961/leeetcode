package org.lcr;

import java.util.*;

public class Solution157 {
    public static void main(String[] args) {
        Solution157 solution157 = new Solution157();
        System.out.println(Arrays.toString(solution157.goodsOrder("1234")));
        System.out.println(Arrays.toString(solution157.goodsOrder("aab")));
    }
    public String[] goodsOrder(String goods) {
        if (goods == null || goods.length() == 0) {
            return new String[0];
        }
        Set<String> list = new HashSet<>();
        Deque<String> deque = new ArrayDeque<>();
        String[] split = goods.split("");
        Set<Integer> set = new HashSet<>();
        dfs(list,deque,split,set);
        String[] strings = new String[list.size()];
        return list.toArray(strings);
    }
//1 2 3 4

    private void dfs(Set<String> list,Deque<String> deque, String[] split,  Set<Integer> set) {
        if (deque.size() == split.length) {
            list.add(append(deque));
            return;
        }
        for (int i = 0; i < split.length; i++) {
            if (set.contains(i)) {
                continue;
            }
            deque.addLast(split[i]);
            set.add(i);
            dfs(list,deque, split, set);
            deque.removeLast();
            set.remove(i);
        }
    }
    private String append(Deque<String> deque){
        StringBuilder stringBuilder = new StringBuilder();
        deque.forEach(stringBuilder::append);
        return stringBuilder.toString();
    }
}
