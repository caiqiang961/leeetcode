package org.lcr;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution176 {

    // 重复计算太多了，性能很差
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        maxDeep = 1;
        int leftDeep = getDeep(root.left);
        maxDeep = 1;
        int rightDeep = getDeep(root.right);
        return Math.abs(rightDeep - leftDeep) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }


    private int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root,new ArrayDeque<>(),1);
        return maxDeep;
    }

    int maxDeep = 1;
    private void dfs(TreeNode root, Deque<TreeNode> deque, int count) {
        if (root == null) {
            return;
        }
        deque.addLast(root);
        maxDeep = Math.max(maxDeep, count);
        dfs(root.left, deque, count + 1);
        dfs(root.right, deque, count + 1);
    }
}
