package org.caiqiang;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution230 {

    // 暴力解法，加数组排序
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        fillList(root,list);
        Collections.sort(list);
        return list.get(k - 1);
    }

    private void fillList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        fillList(root.left, list);
        fillList(root.right, list);
    }
}
