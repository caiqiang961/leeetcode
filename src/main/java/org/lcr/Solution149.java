package org.lcr;

import org.caiqiang.pojo.TreeNode;

import java.util.*;

public class Solution149 {
    public int[] decorateRecord(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        bfs(list, new ArrayDeque<>(), root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void bfs(List<Integer> list, Deque<TreeNode> deque, TreeNode root) {
        if (root == null) {
            return;
        }
        deque.addLast(root);
        while (!deque.isEmpty()) {
            TreeNode currentNode = deque.pollFirst();
            list.add(currentNode.val);
            if (currentNode.left != null) {
                deque.addLast(currentNode.left);
            }
            if (currentNode.right != null) {
                deque.addLast(currentNode.right);
            }
        }
    }
}
