package org.lcr;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Solution174 {
    public int findTargetNode(TreeNode root, int cnt) {
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(deque, root,cnt);
//        int count = 0;
//        while (true) {
//            Integer integer = deque.removeFirst();
//            count++;
//            if (cnt == count) {
//                return integer;
//            }
//        }
        return deque.removeLast();
    }

    private void dfs(Deque<Integer> deque, TreeNode root,int cnt) {
        if (root == null) {
            return;
        }
        dfs(deque, root.right,cnt);
        if (deque.size() == cnt){
            return;
        }
        deque.addLast(root.val);
        if (deque.size() == cnt){
            return;
        }
        dfs(deque, root.left,cnt);
        if (deque.size() == cnt){
            return;
        }
    }
}
