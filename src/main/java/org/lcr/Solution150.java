package org.lcr;

import org.caiqiang.pojo.TreeNode;

import java.util.*;

public class Solution150 {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        bfs(list, new ArrayDeque<>(), root);
        return list;
    }

    private void bfs(List<List<Integer>> list, Deque<TreeNode> deque, TreeNode root) {
        if (root == null) {
            return;
        }
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> currentList = new ArrayList<>();
            List<TreeNode> nextNodes = new ArrayList<>();
            while (!deque.isEmpty()) {
                TreeNode currentNode = deque.pollFirst();
                currentList.add(currentNode.val);
                if (currentNode.left != null) {
                    nextNodes.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    nextNodes.add(currentNode.right);
                }
            }
            list.add(currentList);
            deque.addAll(nextNodes);
        }

    }
}
