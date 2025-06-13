package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        start(root,1);
        return count;
    }

    int count = 0;
    private void start(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (deep > count){
            count = deep;
        }
        start(root.left, deep + 1);
        start(root.right, deep + 1);
    }
}
