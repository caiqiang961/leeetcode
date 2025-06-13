package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

import java.util.List;


public class Solution98 {
    public static void main(String[] args) {
        Solution98 solution98 = new Solution98();
//        System.out.println(solution98.isValidBST(new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)))));
        System.out.println(solution98.isValidBST(new TreeNode(-12, null, new TreeNode(85, new TreeNode(57), null))));
    }


    public boolean isValidBST(TreeNode root) {
      return start(root, Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean start(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val > min && root.val < max) {
            return start(root.left,min,root.val) && start(root.right,root.val,max);
        }
        return false;
    }
}
