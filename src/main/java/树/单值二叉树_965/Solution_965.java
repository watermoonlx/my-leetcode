/**
 * https://leetcode-cn.com/problems/univalued-binary-tree/
 */
package 树.单值二叉树_965;

public class Solution_965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (root.left != null && root.left.val != root.val) {
            return false;
        }
        if (root.right != null && root.right.val != root.val) {
            return false;
        }

        return this.isUnivalTree(root.left) && this.isUnivalTree(root.right);
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
