/**
 * https://leetcode-cn.com/problems/same-tree/
 */
package 树.相同的树_100;

public class Solution_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            if (p.val == q.val) {
                return this.isSameTree(p.left, q.left)
                        && this.isSameTree(p.right, q.right);
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
