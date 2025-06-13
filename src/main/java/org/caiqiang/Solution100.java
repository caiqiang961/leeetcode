package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }
        if (p != null && q != null && p.val == q.val){
            return isSameTree(q.left,p.left) && isSameTree(q.right,p.right);
        }
        return false;
    }
}
