package org.lcr;

import org.caiqiang.pojo.TreeNode;

//          4
//       2      3
//    4    5  6   7
//  8   9

//       1
//    0     1
//  -4  -3

//   1
//-4
public class Solution143 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }
        return dfs(A, B, 1);
    }

    private boolean dfs(TreeNode a, TreeNode b, int count) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val == b.val) {
            if (dfs(a.left, b.left, count + 1) && dfs(a.right, b.right, count + 1)) {
                return true;
            }
        }
        if (count != 1){
            return false;
        }
        return dfs(a.left, b, count) || dfs(a.right, b, count);

    }
}
