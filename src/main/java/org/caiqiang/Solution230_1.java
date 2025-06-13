package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Solution230_1 {
    // 精辟的写法
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()) {
            // 疯狂塞入左值,利用的是栈的先进后出原则
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            // 然后取左值，
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            // 继续并且继续向其中塞入右值
            root = root.right;
        }
        return root.val;
    }
}
