package org.caiqiang;

import java.util.*;

public class Solution93 {
    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        System.out.println(solution93.restoreIpAddresses("25525511135"));
        System.out.println(solution93.restoreIpAddresses("0000"));
        System.out.println(solution93.restoreIpAddresses("101023"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        Deque<String> deque = new ArrayDeque<>();
        start(0, 0, s, deque, result);
        return result;
    }

    private void start(int num, int index, String s, Deque<String> deque, List<String> result) {
        if (num >= 4) {
            if (index >= s.length()) {
                result.add(joinIp(deque));
            }
            return;
        }
        for (int j = 1; j <= 3; j++) {
            if (index + j > s.length()) {
                return;
            }
            String substring = s.substring(index, index + j);
            if (valid(substring)) {
                deque.addLast(substring);
                start(num + 1, index + j, s, deque, result);
                deque.removeLast();
            }
        }
    }

    private String joinIp(Deque<String> deque) {
        ArrayList<String> integers = new ArrayList<>(deque);
        StringJoiner stringJoiner = new StringJoiner("");
        for (int i = 0; i < integers.size(); i++) {
            stringJoiner.add(integers.get(i) + ".");
        }
        String s = stringJoiner.toString();
        return s.substring(0, s.length() - 1);
    }

    private boolean valid(String subStr) {
        if (subStr.length() == 1) {
            return true;
        }
        if (subStr.startsWith("0")) {
            return false;
        }
        if (Integer.parseInt(subStr) > 255) {
            return false;
        }
        return true;
    }
}
