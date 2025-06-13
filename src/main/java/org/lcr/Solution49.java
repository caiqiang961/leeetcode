package org.lcr;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class Solution49 {

    public static void main(String[] args) {
        Solution49 solution49 = new Solution49();

        System.out.println(solution49.sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
    }
    public int sumNumbers(TreeNode root) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        DFS(root, deque, list);
        return list.stream().mapToInt(Integer::intValue).sum();
    }

    private void DFS(TreeNode root, Deque<Integer> deque, List<Integer> list) {
        if (root == null) {
            return;
        }
        deque.addLast(root.val);
        if (checkNode(root)) {
            list.add(sumDeque(deque));
            deque.removeLast();
            return;
        }
        DFS(root.left, deque, list);
        DFS(root.right, deque, list);
        deque.removeLast();
    }

    // 检查节点是否为叶子节点
    private boolean checkNode(TreeNode node) {
        if (node == null) {
            return false;
        }
        return node.left == null && node.right == null;
    }

    private int sumDeque(Deque<Integer> deque) {
        if (deque.size() == 0){
            return 0;
        }
        AtomicReference<String> resultStr = new AtomicReference<>("");
        deque.forEach(e -> {
            resultStr.set(resultStr.get() + e);
        });
        String s = resultStr.get();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '0') {
                break;
            } else {
                index++;
            }
        }
        String substring = s.substring(index);
        if(substring.length() == 0){
            return 0;
        }
        return Integer.parseInt(substring);
    }
}
