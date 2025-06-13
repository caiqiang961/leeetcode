package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

public class solution226 {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            caseTree(root, root.left, root.right);
        }
        return root;
    }

    private void caseTree(TreeNode root, TreeNode left, TreeNode right) {
        if (root == null) {
            return;
        }
        if (left != null) {
            caseTree(left, left.left, left.right);
        }
        if (right != null) {
            caseTree(right, right.left, right.right);
        }
        root.right = left;
        root.left = right;
    }
}
