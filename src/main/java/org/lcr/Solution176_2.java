package org.lcr;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution176_2 {

    // 这个办法好，-1表示不用在计算了，已经有不符合的了，返回其他表示deep
    public boolean isBalanced(TreeNode root) {
        return getDeep(root) != -1;
    }

    private int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDeep = getDeep(root.left);
        int rightDeep = getDeep(root.right);
        if (leftDeep == -1 || rightDeep == -1) {
            return -1;
        }
        // 如果当前节点是叶子节点，则返回1
        if (leftDeep == 0 && rightDeep == 0) {
            return 1;
        }
        if (Math.abs(leftDeep - rightDeep) > 1) {
            return -1;
        } else {
            return Math.max(leftDeep, rightDeep) + 1;
        }
    }
}
