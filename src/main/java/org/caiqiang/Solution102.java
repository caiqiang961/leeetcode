package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        deque.addLast(root);
        while (!deque.isEmpty()) {
            List<Integer> currentList = new ArrayList<>();
            List<TreeNode> currentNode = new ArrayList<>();
            while (!deque.isEmpty()) {
                TreeNode first = deque.removeFirst();
                currentList.add(first.val);
                if (first.left != null) {
                    currentNode.add(first.left);
                }
                if (first.right != null) {
                    currentNode.add(first.right);
                }
            }
            result.add(currentList);
            for (TreeNode treeNode : currentNode) {
                deque.addLast(treeNode);
            }
        }
        return result;
    }
}
