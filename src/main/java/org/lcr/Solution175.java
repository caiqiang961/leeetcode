package org.lcr;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution175 {
    int maxDeep = 0;
    public int calculateDepth(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        dfs(deque,root,1);
        return maxDeep;
    }

    private void dfs(Deque<TreeNode> deque, TreeNode root, int count) {
        if (root == null) {
            return;
        }
        deque.addLast(root);
        maxDeep = Math.max(maxDeep,count);
        dfs(deque, root.right, count + 1);
        dfs(deque, root.left, count + 1);
    }
}
