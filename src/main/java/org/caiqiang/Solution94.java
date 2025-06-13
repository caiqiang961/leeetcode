package org.caiqiang;

import org.caiqiang.pojo.ListNode;
import org.caiqiang.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {


    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return result;
        }
        if (root.left!= null){
            inorderTraversal(root.left);
        }
        result.add(root.val);
        if (root.right != null){
            inorderTraversal(root.right);
        }
        return result;
    }
}
