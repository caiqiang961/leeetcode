package org.lcr;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution151 {
    public List<List<Integer>> decorateRecord(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        bfs(result, new ArrayDeque<>(), root);
        return result;
    }


    private void bfs(List<List<Integer>> list, Deque<TreeNode> deque, TreeNode root) {
        if (root == null) {
            return;
        }
        deque.addLast(root);
        int count = 1;

        while (!deque.isEmpty()) {
            List<Integer> currentList = new ArrayList<>();
            List<TreeNode> currentNodes = new ArrayList<>();
            count++;
            while (!deque.isEmpty()) {
                TreeNode currentNode;
                if (count % 2 != 0){
                    currentNode = deque.pollFirst();
                }else {
                    currentNode = deque.pollLast();
                }

                currentList.add(currentNode.val);

                if (count % 2 != 0) {// 正向，左到右
                    if (currentNode.left != null) {
                        currentNodes.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        currentNodes.add(currentNode.right);
                    }
                } else {// 逆向，右到左
                    if (currentNode.right != null) {
                        currentNodes.add(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        currentNodes.add(currentNode.left);
                    }
                }
            }
            deque.addAll(currentNodes);
            list.add(currentList);
        }
    }
}
