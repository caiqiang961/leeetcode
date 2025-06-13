package org.lcr;

import org.caiqiang.pojo.TreeNode;

public class Solution144 {
    public TreeNode flipTree(TreeNode root) {
        return getNewTreeNode(root);
    }

    private TreeNode getNewTreeNode(TreeNode h) {
        if (h == null){
            return null;
        }
        TreeNode head = new TreeNode(h.val);
        head.left = getNewTreeNode(h.right);
        head.right = getNewTreeNode(h.left);
        return head;
    }
}
