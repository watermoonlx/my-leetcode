/**
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 */
package 树.合并二叉树_617;

public class Solution_617 {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode newRoot = null;
        if (t1 == null && t2 == null) {
            return null;
        } else if (t1 != null && t2 != null) {
            newRoot = new TreeNode(t1.val + t2.val);
            newRoot.left = this.mergeTrees(t1.left, t2.left);
            newRoot.right = this.mergeTrees(t1.right, t2.right);
        } else if (t1 != null) {
            newRoot = new TreeNode(t1.val);
            newRoot.left = this.mergeTrees(t1.left, null);
            newRoot.right = this.mergeTrees(t1.right, null);
        } else {
            newRoot = new TreeNode(t2.val);
            newRoot.left = this.mergeTrees(null, t2.left);
            newRoot.right = this.mergeTrees(null, t2.right);
        }

        return newRoot;
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