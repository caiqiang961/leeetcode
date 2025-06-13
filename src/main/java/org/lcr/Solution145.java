package org.lcr;

import org.caiqiang.pojo.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//       1
//   2        2
//2        2

//[5,4,1,null,1,null,4,2,null,2,null]
//           5
//  4                1
//      1                  4
//    2                 2
// n
public class Solution145 {
    public static void main(String[] args) {
        Solution145 solution145 = new Solution145();
//        solution145.checkSymmetricTree(new TreeNode(1,new TreeNode(2,new TreeNode(2),null),new TreeNode(2,null,new TreeNode(2))));
        solution145.checkSymmetricTree(new TreeNode(2,
                new TreeNode(4,null,new TreeNode(1,new TreeNode(2),null)),
                new TreeNode(1,null,new TreeNode(4,new TreeNode(2),null))));
    }

    public boolean checkSymmetricTree(TreeNode root){
        if (root == null){
            return true;
        }
        return check(root.left,root.right);
    }

    private boolean check(TreeNode q,TreeNode p){
        if (q == null && p == null){
            return true;
        }
        if (q == null || p == null){
            return false;
        }
        if (q.val != p.val){
            return false;
        }
        return check(q.right,p.left) && check(q.left,p.right);
    }

    // 中序遍历，无法解决多级子树问题，如示例[5,4,1,null,1,null,4,2,null,2,null]
    public boolean checkSymmetricTree1(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> list = new ArrayList<>();
        printMiddleFor(root, list);
        System.out.println(list);
        if (list.size() % 2 == 0) {
            return false;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!Objects.equals(list.get(i), list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    private void printMiddleFor(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return;
        }
        if (root.left != null || root.right != null){
            printMiddleFor(root.left, list);
        }
        list.add(root.val);
        if (root.left != null || root.right != null){
            printMiddleFor(root.right, list);
        }
    }

}
