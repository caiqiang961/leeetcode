package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

public class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    private boolean check(TreeNode q, TreeNode p) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null && p.val == q.val) {
            return check(p.left,q.right) && check(p.right,q.left);
        }
        return false;
    }
}
