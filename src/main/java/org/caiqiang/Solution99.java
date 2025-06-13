package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;

// 1 2 3 4 5 6 7
// 1 6 3 4 5 2 7
public class Solution99 {
    public static void main(String[] args) {
        Solution99 solution99 = new Solution99();
    }
    public void recoverTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        sort(root, list);
        TreeNode leftTreeNode = null;
        TreeNode rightTreeNode = null;
        int x = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).val > list.get(i + 1).val) {
                if (leftTreeNode == null) {
                    leftTreeNode = list.get(i);
                    x = i;
                } else {
                    rightTreeNode = list.get(i + 1);
                }
            }
        }
        if (rightTreeNode == null) {
            rightTreeNode = list.get(x + 1);
        }

        assert leftTreeNode != null;
        int temp = leftTreeNode.val;
        leftTreeNode.val = rightTreeNode.val;
        rightTreeNode.val = temp;

    }

    private void sort(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        sort(root.left, list);
        list.add(root);
        sort(root.right, list);
    }
}
