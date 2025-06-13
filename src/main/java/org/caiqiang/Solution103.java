package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return result;
        }
        deque.addLast(root);
        boolean flag = true;
        while (!deque.isEmpty()) {
            List<Integer> currentList = new ArrayList<>();
            List<TreeNode> currentNode = new ArrayList<>();

            while (!deque.isEmpty()) {
                TreeNode first;
                if (flag) {
                    first = deque.removeFirst();
                } else {
                    first = deque.removeLast();
                }
                if (first.left != null) {
                    currentNode.add(first.left);
                }
                if (first.right != null) {
                    currentNode.add(first.right);
                }
                currentList.add(first.val);
                if (!flag) {
                    List<Integer> curr = new ArrayList<>();
                    for (int i = currentList.size() - 1; i >= 0; i--) {
                        curr.add(currentList.get(i));
                    }
                    currentList = curr;
                }
            }
            result.add(currentList);
            flag = !flag;
            if (flag) {
                for (int i = currentNode.size() - 1; i >= 0; i--) {
                    deque.addLast(currentNode.get(i));
                }
            } else {
                for (int i = 0; i < currentNode.size(); i++) {
                    deque.addLast(currentNode.get(i));
                }
            }

        }
        return result;
    }
}
