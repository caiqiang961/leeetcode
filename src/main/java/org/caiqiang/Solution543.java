package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

public class Solution543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxLen(root);
        return ans - 1;
    }

    private int maxLen(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLen = maxLen(root.left);
        int rightLen = maxLen(root.right);
        ans = Math.max(ans, leftLen + rightLen + 1);
        return Math.max(leftLen, rightLen) + 1;
    }
}
